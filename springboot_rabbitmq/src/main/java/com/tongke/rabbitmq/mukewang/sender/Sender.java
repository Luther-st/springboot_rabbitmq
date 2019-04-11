package com.tongke.rabbitmq.mukewang.sender;


import com.tongke.rabbitmq.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {
    Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String sendOrder(Order order){
        String context = "简单消息发送";
        logger.info("简单消息发送时间："+new Date());
        CorrelationData correla = new CorrelationData();
        correla.setId(order.getMessageId());
        rabbitTemplate.convertAndSend(
                "order-exchange", //exchange
                "order.abcd", //routingKey
                order, //消息体内容
                correla //消息唯一ID
        );
        /**
         * 在连接之前，要去控制台做一些创建
         * 1、点击Exchanges，创建一个名为“”
         * 2、点击Queues，创建一个名为“order-queue”的队列
         */
        return "发送成功";
    }

    public static final String MIAOSHA_QUEUE = "order-queue";

    @Bean
    public Queue miaoShaQueue(){
        return new Queue(MIAOSHA_QUEUE,true);
    }

}
