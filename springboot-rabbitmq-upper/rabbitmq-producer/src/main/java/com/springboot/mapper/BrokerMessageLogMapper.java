package com.springboot.mapper;

import com.springboot.model.BrokerMessageLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BrokerMessageLogMapper {

    public int save(BrokerMessageLog brokerMessageLog);

    /**
     * 查询消息状态为0(发送中) 且已经超时的消息集合
     * @return
     */
    public List<BrokerMessageLog> query4StatusAndTimeoutMessage();

    /**
     * 重新发送统计count发送次数 +1
     * @param messageId
     */
    public void update4ReSend(@Param("messageId")String messageId);
    /**
     * 更新最终消息发送结果 成功 or 失败
     * @param messageId
     * @param status
     */
    public void changeBrokerMessageLogStatus(@Param("messageId")String messageId, @Param("status")String status);

}
