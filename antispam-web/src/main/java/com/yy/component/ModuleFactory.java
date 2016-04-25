package com.yy.component;

import backtype.storm.topology.IBasicBolt;
import backtype.storm.topology.IRichSpout;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.topology.base.BaseRichSpout;
import com.yy.cs.base.json.Json;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sunpeixin on 2016/4/7.
 */
public class ModuleFactory {

    public static IBasicBolt buildBlot(String className, String argJson,Integer id,Integer appId) throws Exception{
        Class<?> clazz = Class.forName(className);
        IBasicBolt bean = (IBasicBolt)clazz.newInstance();
        if (StringUtils.isNotEmpty(argJson)) {
            Map<String,Object> args =Json.strToObj(argJson, Map.class);
            args.put("moduleId", id);
            args.put("appId", appId);
            while (clazz != BaseBasicBolt.class) {//循环遍历父类，到baseBasicBolt为止
                for (Field field : clazz.getDeclaredFields()) {
                    if (args.containsKey(field.getName())) {
                        field.setAccessible(true);
                        field.set(bean, args.get(field.getName()));
                    }
                }
                clazz = clazz.getSuperclass();
            }
        }
        return bean;
    }

    public static IRichSpout buildSpout(String className, String argJson,Integer id,Integer appId) throws Exception{
        Class clazz = Class.forName(className);
        IRichSpout bean = (IRichSpout)clazz.newInstance();
        if (StringUtils.isNotEmpty(argJson)) {
            Map<String,Object> args =Json.strToObj(argJson,Map.class);
            args.put("moduleId", id);
            args.put("appId", appId);
            while (clazz != BaseRichSpout.class) {//循环遍历父类，到BaseRichSpout为止
                for (Field field : clazz.getDeclaredFields()) {
                    if (args.containsKey(field.getName())) {
                        field.setAccessible(true);
                        field.set(bean, args.get(field.getName()));
                    }
                }
                clazz = clazz.getSuperclass();
            }
        }
        return bean;
    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("mqAddr", "61.160.35.41:9876");
        map.put("mqConsumerGroup", "ConsumerGroupName");
        map.put("mqTopic", "testApp");
        map.put("mqTags", "*");
        String argJson = Json.ObjToStr(map);
        try {
            //Object bean = ModuleFactory.buildSpout("com.yy.component.spout.DefaultEventSpout", argJson);
            IRichSpout bean = ModuleFactory.buildSpout("com.yy.component.spout.DefaultEventSpout", argJson,1,1);
            System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
