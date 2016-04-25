package com.yy.component.blot;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;

/**
 * Created by Sunpeixin on 2016/3/11.
 * 默认的事件流处理
 *
 * 负责记录事件用于搜索
 */
public class OutputLogBolt extends BaseBasicBolt{

    @Override public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        try {
            System.out.println(tuple.getString(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("info"));
    }
}
