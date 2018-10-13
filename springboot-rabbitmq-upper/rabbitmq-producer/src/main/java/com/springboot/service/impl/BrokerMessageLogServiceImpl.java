package com.springboot.service.impl;

import com.springboot.mapper.BrokerMessageLogMapper;
import com.springboot.model.BrokerMessageLog;
import com.springboot.service.BrokerMessageLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrokerMessageLogServiceImpl implements BrokerMessageLogService {

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    @Override
    public boolean save(BrokerMessageLog brokerMessageLog) {
        return brokerMessageLogMapper.save(brokerMessageLog) > 0;
    }

    @Override
    public List<BrokerMessageLog> query4StatusAndTimeoutMessage() {
        return brokerMessageLogMapper.query4StatusAndTimeoutMessage();
    }

    @Override
    public void update4ReSend(String messageId) {
        brokerMessageLogMapper.update4ReSend(messageId);
    }

    @Override
    public void changeBrokerMessageLogStatus(String messageId, String status) {
        brokerMessageLogMapper.changeBrokerMessageLogStatus(messageId, status);
    }
}
