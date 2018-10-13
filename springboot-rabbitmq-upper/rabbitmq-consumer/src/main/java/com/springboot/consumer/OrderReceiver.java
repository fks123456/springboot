package com.springboot.consumer;

import com.rabbitmq.client.Channel;
import com.springboot.model.Order;
import com.springboot.utils.FastJsonConvertUtil;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
public class OrderReceiver {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue", durable = "true"),
            exchange = @Exchange(value = "order-exchange", durable = "true", type = "topic"),
            key = "order.*"
    ))
    @RabbitHandler
    public void handleOrder(@Payload String orderStr, Channel channel, @Headers Map<String, Object> headers) throws IOException {
        Order order = FastJsonConvertUtil.convertJSONToObject(orderStr, Order.class);

        System.err.println("==============================");
        System.err.println("订单信息打印：");
        System.err.println(order.toString());
        System.err.println("==============================");

        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }
}
