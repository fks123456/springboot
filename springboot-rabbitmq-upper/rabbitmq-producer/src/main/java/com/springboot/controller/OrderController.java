package com.springboot.controller;

import com.springboot.constant.Constants;
import com.springboot.model.BrokerMessageLog;
import com.springboot.model.Order;
import com.springboot.producer.OrderSender;
import com.springboot.service.BrokerMessageLogService;
import com.springboot.service.OrderService;
import com.springboot.utils.FastJsonConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private BrokerMessageLogService brokerMessageLogService;
    @Autowired
    private OrderSender orderSender;

    @RequestMapping("/save")
    @Transactional
    public String save(Order order) {
        String messageId = System.currentTimeMillis() + "$" + UUID.randomUUID().toString();

        order.setMessageId(messageId);

        if (!orderService.save(order)) {
            throw new RuntimeException();
        }

        BrokerMessageLog log = new BrokerMessageLog();
        log.setMessageId(messageId);
        String orderStr = FastJsonConvertUtil.convertObjectToJSON(order);
        log.setMessage(orderStr);
        log.setTryCount(0);
        log.setStatus(Constants.ORDER_SENDING);
        log.setNextRetry(new Date(new Date().getTime() + 60000* Constants.ORDER_TIMEOUT));
        log.setCreateTime(new Date());
        log.setUpdateTime(new Date());

        if(!brokerMessageLogService.save(log)) {
            throw new RuntimeException();
        }

        try {
            orderSender.send(order);
        } catch (Exception e) {
            System.err.println("传送过程出现异常");
            e.printStackTrace();
        }

        return "保存成功";
    }
}
