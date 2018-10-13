package com.springboot.consumer;

import com.rabbitmq.client.Channel;
import com.springboot.model.Order;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderReceiver {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order.queue", durable = "true"),
            exchange = @Exchange(value = "order.exchange", durable = "true", type = "topic"),
            key = "order.*"
    ))
    @RabbitHandler
    public void handle(@Payload Order order,
                       Channel channel,
                       @Headers Map<String, Object> headers) throws Exception {
        System.err.println("===========================");
        System.err.println("订单信息");
        System.err.println(order.toString());
        System.err.println("===========================");


        Long deliverTag = (Long)headers.get(AmqpHeaders.DELIVERY_TAG);
        // 手动签收
        channel.basicAck(deliverTag, false);
    }
}
