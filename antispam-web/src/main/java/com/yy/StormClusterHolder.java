package com.yy;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.KillOptions;
import backtype.storm.topology.*;
import com.yy.business.bean.GroupType;
import com.yy.business.bean.ModuleType;
import com.yy.business.dao.custom.CustomAppModuleMapper;
import com.yy.business.dao.gen.mapper.AppConfigMapper;
import com.yy.business.dao.gen.model.AppConfig;
import com.yy.business.dao.gen.model.AppConfigExample;
import com.yy.business.dao.gen.model.AppModule;
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
    AppConfigMapper appConfigMapper;

    @Autowired
    CustomAppModuleMapper customAppModuleMapper;

    LocalCluster cluster = new LocalCluster();

    public void start() throws Exception{
        List<AppConfig> appConfigs = appConfigMapper.selectByExample(new AppConfigExample());
        for (AppConfig appConfig : appConfigs) {
            Config config = new Config();
            config.setDebug(true);
            config.setMaxTaskParallelism(appConfig.getMaxTaskParallelism());
            TopologyBuilder topologyBuilder = new TopologyBuilder();

            List<AppModule> modules = customAppModuleMapper.selectAll(appConfig.getAppid());
            for (AppModule module : modules) {
                if (module.getModuleType() == ModuleType.SPOUT.getType()) {
                    IRichSpout spout = ModuleFactory.buildSpout(module.getModuleClass(), module.getModuleArg(),module.getId(),module.getAppId());
                    topologyBuilder.setSpout(module.getModuleName(), spout, module.getParallelism());
                }else if (module.getModuleType() == ModuleType.BOLT.getType()) {
                    IBasicBolt bolt = ModuleFactory.buildBlot(module.getModuleClass(), module.getModuleArg(),module.getId(),module.getAppId());
                    BoltDeclarer declarer = topologyBuilder
                            .setBolt(module.getModuleName(), bolt, module.getParallelism());
                    if (StringUtils.isNotEmpty(module.getUpstreamModuleName())) {
                        if (module.getGroupType() == GroupType.SHUFFLE.getType()) {
                            declarer.shuffleGrouping(module.getUpstreamModuleName());
                        }
                    }
                }
            }

            cluster.submitTopology(appConfig.getAppName(), config, topologyBuilder.createTopology());
        }
    }

    //TODO 这个方法在上一次reload没完成之前不能再出发下一次reload
    public void reload(int appId) throws Exception{

        AppConfig appConfig = appConfigMapper.selectByPrimaryKey(appId);
        List<AppModule> modules = customAppModuleMapper.selectAll(appConfig.getAppid());

        Config config = new Config();
        config.setDebug(true);
        config.setMaxTaskParallelism(appConfig.getMaxTaskParallelism());
        TopologyBuilder topologyBuilder = new TopologyBuilder();

        for (AppModule module : modules) {
            if (module.getModuleType() == ModuleType.SPOUT.getType()) {
                IRichSpout spout = ModuleFactory.buildSpout(module.getModuleClass(), module.getModuleArg(),module.getId(),module.getAppId());
                topologyBuilder.setSpout(module.getModuleName(), spout, module.getParallelism());
            }else if (module.getModuleType() == ModuleType.BOLT.getType()) {
                IBasicBolt bolt = ModuleFactory.buildBlot(module.getModuleClass(), module.getModuleArg(),module.getId(),module.getAppId());
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
                cluster.killTopologyWithOpts(appConfig.getAppName(),options);
                break;
            } catch (Exception e) {
                System.out.println("killTopology failed will retry after 3s");
                Thread.sleep(3000);
            }
        }
        while (true) {
            try {
                cluster.submitTopology(appConfig.getAppName(), config, topologyBuilder.createTopology());
                break;
            } catch (Exception e) {
                System.out.println("submitTopology failed will retry after 3s");
                Thread.sleep(3000);
            }
        }
    }
}
