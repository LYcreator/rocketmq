package com.ly.rocketmq.config;

import com.ly.rocketmq.producer.RocketMQProducer;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author ：LY
 * @date ：2021/4/13 13:31
 * @description ：RocketMQConfig
 */

@Component
public class RocketMQConfig {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @PostConstruct
    public void init(){
        RocketMQProducer.mqTemplate = rocketMQTemplate;
    }
}
