package com.springboot.producer;

import com.springboot.constant.Constants;
import com.springboot.model.Order;
import com.springboot.service.BrokerMessageLogService;
import com.springboot.utils.FastJsonConvertUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private BrokerMessageLogService brokerMessageLogService;

    //回调函数: confirm确认
    final RabbitTemplate.ConfirmCallback confirmCallback = new RabbitTemplate.ConfirmCallback() {
        @Override
        public void confirm(CorrelationData data, boolean ack, String cause) {
            System.err.println("=====================================");
            System.err.println("执行回调函数");
            System.err.println("correlationData: " + data);
            System.err.println("=====================================");
            String messageId = data.getId();
            if(ack){
                //如果confirm返回成功 则进行更新
                brokerMessageLogService.changeBrokerMessageLogStatus(messageId, Constants.ORDER_SEND_SUCCESS);
            } else {
                //失败则进行具体的后续操作:重试 或者补偿等手段
                System.err.println("异常处理...");
            }
        }
    };

    public void send(Order order) {

        rabbitTemplate.setConfirmCallback(confirmCallback);

        CorrelationData data = new CorrelationData();
        data.setId(order.getMessageId());

        rabbitTemplate.convertAndSend(
                "order-exchange",
                "order.*",
                FastJsonConvertUtil.convertObjectToJSON(order),
                data
        );
    }
}
