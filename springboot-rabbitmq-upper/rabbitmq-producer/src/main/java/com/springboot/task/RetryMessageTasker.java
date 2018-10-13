package com.springboot.task;

import com.springboot.constant.Constants;
import com.springboot.model.BrokerMessageLog;
import com.springboot.producer.OrderSender;
import com.springboot.service.BrokerMessageLogService;
import com.springboot.utils.FastJsonConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RetryMessageTasker {

    @Autowired
    private BrokerMessageLogService brokerMessageLogService;
    @Autowired
    private OrderSender orderSender;

    @Scheduled(initialDelay = 5000, fixedDelay = 10000)
    public void retry() {

        System.err.println("==================================");
        System.err.println("进入定时任务");
        System.err.println("==================================");


        List<BrokerMessageLog> logs = brokerMessageLogService.query4StatusAndTimeoutMessage();

        for (BrokerMessageLog log: logs) {
            if(log.getTryCount() >= 3) {
                brokerMessageLogService.changeBrokerMessageLogStatus(log.getMessageId(), Constants.ORDER_SEND_FAILURE);
            } else {
                try {
                    orderSender.send(FastJsonConvertUtil.convertJSONToObject(log.getMessage(), BrokerMessageLog.class));
                }catch (Exception e){
                    System.err.println("传送过程出现异常");
                    e.printStackTrace();
                }
                brokerMessageLogService.update4ReSend(log.getMessageId());
            }
        }
    }
}
