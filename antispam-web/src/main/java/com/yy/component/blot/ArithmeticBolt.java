package com.yy.component.blot;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import com.yy.cs.base.json.Json;
import org.apache.commons.lang3.StringUtils;
import org.mvel2.MVEL;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/19.
 */
public class ArithmeticBolt extends BaseMatchBolt {

    Serializable compiled;

    String expression;

    @Override public void prepare(Map stormConf, TopologyContext context) {
        super.prepare(stormConf,context);
        if (StringUtils.isEmpty(expression)) {
            //TODO log error
            return;
        }
        load();
    }

    @Override protected void load() {
        compiled = MVEL.compileExpression(expression);
    }

    @Override public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        String data = tuple.getString(0);
        Map<String, Object> dataMap = Json.strToObj(data, Map.class);
        Boolean result = (Boolean) MVEL.executeExpression(compiled, dataMap);
        if (result) {
            emit(basicOutputCollector,dataMap);
        }
    }

    @Override public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("info"));
    }
}
