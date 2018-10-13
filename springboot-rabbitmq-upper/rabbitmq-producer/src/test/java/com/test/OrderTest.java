package com.test;

import com.springboot.model.Order;
import com.springboot.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void test1() {
        Order order = new Order();
        order.setName("测试订单");
        order.setMessageId("测试id");

        orderService.save(order);
    }
}
