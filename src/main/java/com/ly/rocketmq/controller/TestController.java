package com.ly.rocketmq.controller;


import com.ly.rocketmq.producer.RocketMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：LY
 * @date ：2021/4/13 13:45
 * @description ：TestController
 */

@RestController
public class TestController {



    @RequestMapping("/send")
    public void send(){
        for (int i = 0; i < 100; i++) {
            RocketMQProducer.send("test_topic", i + "、这是我发的同步消息！");
        }
    }

    /**
     * 发送异步消息
     * @author tyg
     * @date 2021-03-25 11:57
     */
    @RequestMapping("/sendAsync")
    public void sendAsync() {
        for (int i = 0; i < 100; i++) {
            RocketMQProducer.sendAsync("test_topic", i + "、这是我发的异步消息！", new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println(sendResult.getMsgId()+"成功");
                }
                @Override
                public void onException(Throwable throwable) {
                    System.out.println(throwable.getMessage());
                }
            });
        }
    }

    /**
     * 发送延迟同步消息
     * @author tyg
     * @date 2021-03-25 11:57
     */
    @RequestMapping("/sendDelay")
    public void sendDelay() {
        for (int i = 0; i < 100; i++) {
            RocketMQProducer.sendDelay("test_topic", i + "、这是我发的延迟消息！", 2);
        }
    }

}
