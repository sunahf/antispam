package com.yy.component.blot;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import com.yy.util.HttpUtil;
import com.yy.cs.base.json.Json;

import java.util.*;

/**
 * Created by Administrator on 2016/4/19.
 *
 * test arg json:
 *
 * {"baseUrl":"http://127.0.0.1/test/getList","urlValKey":"list","key":"noAccessToken","ifIn":"true","spamMatchMsg":"noAccessToken值包含在测试白名单里"}
 */
public class ListMatchBolt extends BaseMatchBolt {

    private String baseUrl;

    private String urlValKey;

    private Long delay=60000l;//毫秒

    private List<Object> list = new ArrayList<>();

    private String key;

    private boolean ifIn=false;

    public ListMatchBolt() {

    }

    @Override public void prepare(Map stormConf, TopologyContext context) {
        super.prepare(stormConf,context);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                loadData();
            }
        },0, delay);
    }

    @Override protected void load() {

    }

    private void loadData() {
        try {
            String httpVal = HttpUtil.get(baseUrl);
            Map<String, Object> map = Json.strToObj(httpVal, Map.class);
            list = (List<Object>) map.get(urlValKey);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        try {

            String data = tuple.getString(0);
            Map<String, Object> dataMap = Json.strToObj(data, Map.class);
            Object value = dataMap.get(key);
            if (ifIn&&list.contains(value)) {
                emit(basicOutputCollector,dataMap);
            }
            if (!ifIn&&!list.contains(value)) {
                emit(basicOutputCollector,dataMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("info"));
    }


}
