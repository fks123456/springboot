package com.springboot.producer;

import com.springboot.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Order order) {

        CorrelationData data = new CorrelationData();
        data.setId(order.getMessageId());

        rabbitTemplate.convertAndSend(
                "order.exchange",  // 交换机
                "order.*",  //
                order,    // 消息实体对象
                data      // 消息唯一id
        );
    }
}
