package com.yy.component.blot;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import com.yy.cs.base.json.Json;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Created by Administrator on 2016/4/20.
 */
public abstract class BaseMatchBolt extends AutoConfigBolt{

    protected String spamMatchMsg;


    @Override public void prepare(Map stormConf, TopologyContext context) {
        super.prepare(stormConf,context);
    }

    @Override public void execute(Tuple input, BasicOutputCollector collector) {

    }

    @Override public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }

    protected void emit(BasicOutputCollector collector,Map<String,Object> dataMap) {
        //add toMatchMsg;
        String spamMatchMsg = (String) dataMap.get("spamMatchMsg");
        if (StringUtils.isEmpty(spamMatchMsg)) {
            spamMatchMsg = this.spamMatchMsg;
        } else {
            spamMatchMsg += "|" + this.spamMatchMsg;
        }
        dataMap.put("spamMatchMsg", spamMatchMsg);
        //往下发
        String data = Json.ObjToStr(dataMap);
        if (StringUtils.isNotEmpty(data)) {
            collector.emit(new Values(data));
        }
    }
}
