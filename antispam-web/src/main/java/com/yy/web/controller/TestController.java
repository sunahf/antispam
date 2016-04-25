package com.yy.web.controller;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.yy.StormClusterHolder;
import com.yy.cs.base.json.Json;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/28.
 */

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    StormClusterHolder holder;

    DefaultMQProducer producer = new DefaultMQProducer("Producer");

    boolean ifinit=false;

    private void init() throws Exception{
        if(!ifinit){
            /**
             * Producer对象在使用之前必须要调用start初始化，初始化一次即可<br>
             * 注意：切记不可以在每次发送消息时，都调用start方法
             */
            producer.setNamesrvAddr("61.160.35.40:9876");
            producer.start();

        }
        ifinit=true;
    }

    @RequestMapping(value = "/inputData", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String inputData(
            HttpServletRequest request,
            @RequestParam(required = false) String json) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        init();
        String testJson = "{\"noAccessToken\":1}";
        if (StringUtils.isEmpty(json)) {
            json=testJson;
        }
        Message msg = new Message("testApp","TagA",System.currentTimeMillis()/1000+"",json.getBytes());
        SendResult sendResult = producer.send(msg);
        System.out.println(sendResult);
        return "success";
    }

    @RequestMapping(value = "/reload", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String reload(
            HttpServletRequest request,
            @RequestParam Integer appId) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        holder.reload(appId);
        return "success";
    }

    @RequestMapping(value = "/getList", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getList(
            HttpServletRequest request) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        return Json.ObjToStr(map);
    }
}
