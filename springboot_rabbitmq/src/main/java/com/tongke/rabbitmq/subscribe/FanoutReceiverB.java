package com.tongke.rabbitmq.subscribe;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FanoutReceiverB {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "fanout.B",durable = "true"),
            exchange = @Exchange(name="fanout-exchange",durable = "true",type = "topic"),
            key = "fanout.*"
    )
    )
    @RabbitHandler
    public void onOrderMessage(@Payload String hello, @Headers Map<String,Object> headers, Channel channel) throws Exception {
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        boolean multiple = false;
        channel.basicAck(deliveryTag,multiple);
        System.out.println("fanoutB  : " + hello);
    }
}
