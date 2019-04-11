package com.tongke.rabbitmq.factory;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NeoReceiver2 {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "neo-queue",durable = "true"),
            exchange = @Exchange(name="neo-exchange",durable = "true",type = "topic"),
            key = "neo.*"
    )
    )
    @RabbitHandler
    public void onOrderMessage(@Payload String hello, @Headers Map<String,Object> headers, Channel channel) throws Exception {
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);

        /**
         *  multiple 取值为 false 时，表示通知 RabbitMQ 当前消息被确认
         *  如果为 true，则额外将比第一个参数指定的 delivery tag 小的消息一并确认
         */
        boolean multiple = false;

        //ACK,确认一条消息已经被消费
        channel.basicAck(deliveryTag,multiple);

        System.out.println("Receiver2  : " + hello);
    }
}
