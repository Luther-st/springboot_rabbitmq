package com.tongke.rabbitmq.subscribe;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FanoutSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {

        String context = "hi, fanout msg ";
        System.out.println("Sender : " + context);
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("fanout-exchange","fanout.abcd",context,correlationData);


    }
}
