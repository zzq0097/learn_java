package com.zzq.learn.mq.rabbitmq;

import cn.hutool.core.util.StrUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MsgListener {

    @RabbitListener
    public void consume(String message) {
        System.out.println(StrUtil.format("消费者消费消息 ===> {}", message));
    }
}
