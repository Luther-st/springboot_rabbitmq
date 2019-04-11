package com.tongke.rabbitmq.helloword;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.UUID;

@Controller
public class HelloSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send() {

       String s = "13545687565555";
        System.out.println("send + " + s);
        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("hello-exchange","hello.abcd",s,correlationData);

    }

    @Bean
    public Queue Queue() {
        return new Queue("hello-queue");
    }
}
