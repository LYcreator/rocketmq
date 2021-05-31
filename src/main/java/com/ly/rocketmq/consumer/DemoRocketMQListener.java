package com.ly.rocketmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author ：LY
 * @date ：2021/4/13 13:41
 * @description ：DemoRocketMQListener
 */

@Slf4j
@Component
@RocketMQMessageListener(topic = "test_topic", consumerGroup = "my_group")
public class DemoRocketMQListener implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt message) {
        byte[] body = message.getBody();
        String msg = new String(body);
        log.info("接收到消息：{}, 重试次数：{}", msg, message.getReconsumeTimes());
    }
}
