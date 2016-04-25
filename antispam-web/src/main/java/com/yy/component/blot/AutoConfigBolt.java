package com.yy.component.blot;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import com.yy.cs.base.json.Json;
import com.yy.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/4/21.
 */
public abstract class AutoConfigBolt extends BaseBasicBolt{

    protected Integer appId;

    protected Integer moduleId;

    protected String loadConfigUrl="http://127.0.0.1/config/getModuleArg";//这个应该所有bolt都是一样的


    @Override public void prepare(Map stormConf, TopologyContext context) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                try {
                    reloadConfig();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },0, 60000);
        super.prepare(stormConf, context);
    }

    protected void reloadConfig() throws Exception{
        Class clazz=this.getClass();

        String url = loadConfigUrl + "?appId="+appId+"&moduleId="+moduleId;
        String configJson = HttpUtil.get(url);
        Map<String, Object> args = Json.strToObj(configJson, Map.class);
        while (clazz != BaseBasicBolt.class) {//循环遍历父类，到baseBasicBolt为止
            for (Field field : clazz.getDeclaredFields()) {
                if (args.containsKey(field.getName())) {
                    field.setAccessible(true);
                    field.set(this, args.get(field.getName()));
                }
            }
            clazz = clazz.getSuperclass();
        }
        load();
    }

    protected abstract void load();

    @Override public void execute(Tuple input, BasicOutputCollector collector) {

    }

    @Override public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

}
