package com.springboot.service.impl;

import com.springboot.mapper.OrderMapper;
import com.springboot.model.Order;
import com.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean save(Order order) {
        return orderMapper.save(order) > 0;
    }
}
