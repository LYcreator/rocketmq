package com.ly.rocketmq;

import com.ly.rocketmq.producer.RocketMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author ：LY
 * @date ：2021/4/13 15:18
 * @description ：Test1
 */

@SpringBootTest
public class Test1 {
    /**
     * 发送同步消息
     * @author tyg
     * @date 2021-03-25 11:57
     */
    @Test
    void send() {
        for (int i = 0; i < 50; i++) {
            RocketMQProducer.send("test_topic", i + "、这是我发的同步消息！");
        }
    }

    /**
     * 发送异步消息
     * @author tyg
     * @date 2021-03-25 11:57
     */
    @Test
    void sendAsync() {
        for (int i = 0; i < 100; i++) {
            RocketMQProducer.sendAsync("test_topic", i + "、这是我发的异步消息！", new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    // 处理成功逻辑
                }
                @Override
                public void onException(Throwable throwable) {
                    // 处理异常逻辑
                }
            });
        }
    }

    /**
     * 发送延迟同步消息
     * @author tyg
     * @date 2021-03-25 11:57
     */
    @Test
    void sendDelay() {
        for (int i = 0; i < 100; i++) {
            RocketMQProducer.sendDelay("test_topic", i + "、这是我发的延迟消息！", 2);
        }
    }
}
