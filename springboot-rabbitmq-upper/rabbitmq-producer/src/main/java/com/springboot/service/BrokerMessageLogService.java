package com.springboot.service;

import com.springboot.model.BrokerMessageLog;

import java.util.List;

public interface BrokerMessageLogService {
    public boolean save(BrokerMessageLog brokerMessageLog);

    public List<BrokerMessageLog> query4StatusAndTimeoutMessage();

    public void update4ReSend(String messageId);

    public void changeBrokerMessageLogStatus(String messageId, String status);

}
