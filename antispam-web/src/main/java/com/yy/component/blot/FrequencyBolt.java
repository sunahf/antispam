package com.yy.component.blot;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.tuple.Tuple;
import com.yy.cs.base.json.Json;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * Created by Administrator on 2016/4/19.
 *
 * x min / y time
 */
public class FrequencyBolt extends BaseMatchBolt {

    private int xMin;

    private int yTime;

    private String key;//哪一个条件相同

    private String host;

    private Integer port;

    //-----------------------------------------------------

    private Jedis jedis;

    @Override public void prepare(Map stormConf, TopologyContext context) {
        super.prepare(stormConf,context);
        load();
    }

    @Override protected void load() {
        if (jedis == null) {
            jedis = new Jedis(host, port);
        }

        if (jedis.getClient().getPort() != port || (!jedis.getClient().getHost().equals(host))) {
            jedis = new Jedis(host, port);
        }
    }

    @Override public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        String data = tuple.getString(0);
        Map<String, Object> dataMap = Json.strToObj(data, Map.class);

        String redisKey="str_"+strategyId+"_module_"+moduleId;
        if (StringUtils.isNotEmpty(key)) {
            redisKey = redisKey+"_"+key+"_"+dataMap.get(key);
        }
        boolean ifMatch = checkSpamByYTimesPerXMin(redisKey, System.currentTimeMillis()+"", yTime, xMin);
        if (ifMatch) {
            emit(basicOutputCollector,dataMap);
        }
    }

    @Override public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }

    private boolean checkSpamByYTimesPerXMin(String redisKey,String redisValue,int ytimes,int xmin) {
        int filterTime = 60 * xmin;// filterMin分钟
        int filterNum = ytimes;

        boolean result = false;

        long now = System.currentTimeMillis();
        long before = now - filterTime * 1000;

        long count = jedis.zcount(redisKey, before, System.currentTimeMillis());

        if (count >= filterNum) {
            result = true;
        } else {
            //这里的超时时间其实没有多大用，主要是用于：取消了策略或者策略部分value匹配不到之后，超过该时间能够自动清掉这部分数据,
            jedis.zadd(redisKey, now, redisValue);
        }

        jedis.zremrangeByScore(redisKey,0,before);//比方说查5分钟内的，那么这个方法就去掉超过5分钟的value

        return result;
    }
}
