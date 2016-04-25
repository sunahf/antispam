package com.yy.component.blot;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import com.yy.util.HttpUtil;
import com.yy.cs.base.json.Json;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/4/18.
 *
 * 现在没有用到field，因为field得提前预先知道传输的格式
 */
public class AppendDataBolt extends BaseBasicBolt {

    private String baseUrl;
    /**
     * field key:url arg key
     */
    private Map<String,String> urlArgMap;

    /**
     * in http return value
     * key : value type(String,Integer..)
     */
    private Map<String,String> urlValMap;

    public AppendDataBolt() {

    }
    @Override public void prepare(Map stormConf, TopologyContext context) {
        super.prepare(stormConf,context);
    }

    @Override public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        try {

            String data = tuple.getString(0);
            Map<String, Object> dataMap = Json.strToObj(data, Map.class);


            String urlAppendArg = "";
            if (urlValMap == null||urlValMap.size()==0) {
                System.out.println("AppendDataBlot urlValMap is empty");
                return;
            }
            if (urlArgMap == null) {
                urlArgMap = new HashMap<>();
            }
            for (String key : urlArgMap.keySet()) {
                String val = dataMap.get(key).toString();//不支持list map object
                if (StringUtils.isNotEmpty(val)) {
                    urlAppendArg = urlAppendArg + "&" + urlArgMap.get(key) + "=" + val;
                }
            }
            String httpValue = HttpUtil.get(baseUrl + urlAppendArg);
            //如果http get到的数据中，有的已经存在tuple里了的话，用tuple的
            Map<String,Object> appendValues = Json.strToObj(httpValue, Map.class);
            for (String key : appendValues.keySet()) {
                //配置项没有要求填充该数据or该数据在上游已经有了
                if((!urlValMap.containsKey(key))||dataMap.containsKey(key))
                    continue;
                //append data
                dataMap.put(key, appendValues.get(key));
            }
            data = Json.ObjToStr(dataMap);
            if (StringUtils.isNotEmpty(data)) {
                basicOutputCollector.emit(new Values(data));
            }
        } catch (Exception e) {
            e.printStackTrace();//TODO log
        }
    }

    @Override public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("info"));
    }


}
