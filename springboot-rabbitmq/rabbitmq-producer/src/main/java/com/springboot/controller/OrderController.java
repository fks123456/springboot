package com.springboot.controller;

import com.springboot.model.Order;
import com.springboot.producer.OrderSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderSender orderSender;

    @RequestMapping("/send")
    public String send(Order order) {
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        orderSender.send(order);

        return "发送成功";
    }
}
