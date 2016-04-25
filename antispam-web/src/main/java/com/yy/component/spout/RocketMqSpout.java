package com.yy.component.spout;

import backtype.storm.spout.SpoutOutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichSpout;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Values;
import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Sunpeixin on 2016/3/11.
 *
 * 默认的事件流输入
 * 所有的业务事件都要往该spout发
 * 用于存储所有的事件流，用于后续搜索
 */
public class RocketMqSpout extends BaseRichSpout {

    private SpoutOutputCollector collector;

    private BlockingDeque<String> sendingQueue = new LinkedBlockingDeque<>();

    private String mqAddr;

    private String mqConsumerGroup;

    private String mqTopic;

    private String mqTags;

    private DefaultMQPushConsumer consumer;

    public RocketMqSpout() {

    }

    public RocketMqSpout(String mqAddr, String mqConsumerGroup, String mqTopic, String mqTags) {
        this.mqAddr = mqAddr;
        this.mqConsumerGroup = mqConsumerGroup;
        this.mqTopic = mqTopic;
        this.mqTags = mqTags;
    }

    @Override public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("source"));
    }

    @Override public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        this.collector = spoutOutputCollector;
        try {
            consumer = new DefaultMQPushConsumer(mqConsumerGroup);
            consumer.setNamesrvAddr(mqAddr);
            consumer.subscribe(mqTopic, mqTags);
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                public ConsumeConcurrentlyStatus consumeMessage(
                        List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    for (MessageExt msg : msgs) {
                        sendingQueue.push(new String(msg.getBody()));
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            //这里的instance name要改，不改的话，reload topology后，会声明同样的instance name，然后抛异常了
            consumer.getDefaultMQPushConsumerImpl().getDefaultMQPushConsumer().setInstanceName(
                    "DefaultEventSpout" + System.currentTimeMillis());
            consumer.getDefaultMQPushConsumerImpl().getDefaultMQPushConsumer().setMessageModel(MessageModel.CLUSTERING);
            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override public void nextTuple() {
        String value = sendingQueue.poll();
        if (StringUtils.isNotEmpty(value)) {
            collector.emit(new Values(value));
        }
    }

    @Override
    public void close() {
        //delete topology 后要 关掉之前的consumer，因为 messagemodel是clustering
        //不关的话storm不会清理的，导致消息发到之前delete掉的topology里的consumer里
        consumer.shutdown();
    }
}
