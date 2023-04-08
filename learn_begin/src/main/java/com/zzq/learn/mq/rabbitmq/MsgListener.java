package com.zzq.learn.mq.rabbitmq;

import cn.hutool.core.util.StrUtil;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MsgListener {

    @RabbitListener(queuesToDeclare = @Queue("directQueue"))
    public void consume(String message) {
        System.out.println(StrUtil.format("消费者消费消息 ===> {}", message));
    }

    @RabbitListener(queues = "sys.dead.queue")
    public void deadMsg(String message) {
        System.out.println(StrUtil.format("dead消息 ===> {}", message));
    }
}
