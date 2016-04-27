package com.yy;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.KillOptions;
import backtype.storm.topology.*;
import com.yy.business.bean.GroupType;
import com.yy.business.bean.ModuleType;
import com.yy.business.dao.custom.CustomModuleMapper;
import com.yy.business.dao.gen.mapper.AppMapper;
import com.yy.business.dao.gen.mapper.StrategyMapper;
import com.yy.business.dao.gen.model.*;
import com.yy.component.ModuleFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * web进程初始启动的时候执行的逻辑
 *
 * 1. 用于初始化Default Topology
 */
public class StormClusterHolder
{

    @Autowired
    AppMapper appMapper;

    @Autowired
    StrategyMapper strategyMapper;

    @Autowired
    CustomModuleMapper customModuleMapper;

    LocalCluster cluster = new LocalCluster();

    public void start() throws Exception{
        List<App> apps = appMapper.selectByExample(new AppExample());
        for (App app : apps) {
            StrategyExample strategyExample = new StrategyExample();
            strategyExample.createCriteria().andAppIdEqualTo(app.getId());
            List<Strategy> strategies = strategyMapper.selectByExample(strategyExample);
            for (Strategy strategy : strategies) {
                Config config = new Config();
                config.setDebug(true);
                config.setMaxTaskParallelism(strategy.getMaxTaskParallelism());
                TopologyBuilder topologyBuilder = new TopologyBuilder();

                List<Module> modules = customModuleMapper.selectAll(strategy.getId());
                for (Module module : modules) {
                    if (module.getModuleType() == ModuleType.SPOUT.getType()) {
                        IRichSpout spout = ModuleFactory
                                .buildSpout(module.getModuleClass(), module.getModuleArg(), module.getId(),
                                        module.getStrategyId());
                        topologyBuilder.setSpout(module.getModuleName(), spout, module.getParallelism());
                    } else if (module.getModuleType() == ModuleType.BOLT.getType()) {
                        IBasicBolt bolt = ModuleFactory
                                .buildBlot(module.getModuleClass(), module.getModuleArg(), module.getId(),
                                        module.getStrategyId());
                        BoltDeclarer declarer = topologyBuilder
                                .setBolt(module.getModuleName(), bolt, module.getParallelism());
                        if (StringUtils.isNotEmpty(module.getUpstreamModuleName())) {
                            if (module.getGroupType() == GroupType.SHUFFLE.getType()) {
                                declarer.shuffleGrouping(module.getUpstreamModuleName());
                            }
                        }
                    }
                }

                cluster.submitTopology(strategy.getStrategyName(), config, topologyBuilder.createTopology());
            }
        }
    }

    //TODO 这个方法在上一次reload没完成之前不能再出发下一次reload
    public void reload(int strategyId) throws Exception{

        Strategy strategy = strategyMapper.selectByPrimaryKey(strategyId);

        List<Module> modules = customModuleMapper.selectAll(strategy.getId());

        Config config = new Config();
        config.setDebug(true);
        config.setMaxTaskParallelism(strategy.getMaxTaskParallelism());
        TopologyBuilder topologyBuilder = new TopologyBuilder();

        for (Module module : modules) {
            if (module.getModuleType() == ModuleType.SPOUT.getType()) {
                IRichSpout spout = ModuleFactory.buildSpout(module.getModuleClass(), module.getModuleArg(),module.getId(),module.getStrategyId());
                topologyBuilder.setSpout(module.getModuleName(), spout, module.getParallelism());
            }else if (module.getModuleType() == ModuleType.BOLT.getType()) {
                IBasicBolt bolt = ModuleFactory.buildBlot(module.getModuleClass(), module.getModuleArg(),module.getId(),module.getStrategyId());
                BoltDeclarer declarer = topologyBuilder
                        .setBolt(module.getModuleName(), bolt, module.getParallelism());
                if (StringUtils.isNotEmpty(module.getUpstreamModuleName())) {
                    if (module.getGroupType() == GroupType.SHUFFLE.getType()) {
                        declarer.shuffleGrouping(module.getUpstreamModuleName());
                    }
                }
            }
        }
        while (true) {
            try {
                KillOptions options = new KillOptions();
                options.set_wait_secs(1);
                cluster.killTopologyWithOpts(strategy.getStrategyName(),options);
                break;
            } catch (Exception e) {
                System.out.println("killTopology failed will retry after 3s");
                Thread.sleep(3000);
            }
        }
        while (true) {
            try {
                cluster.submitTopology(strategy.getStrategyName(), config, topologyBuilder.createTopology());
                break;
            } catch (Exception e) {
                System.out.println("submitTopology failed will retry after 3s");
                Thread.sleep(3000);
            }
        }
    }
}
