package com.zzq.learn.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class SimpleTest {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {
        rabbitTemplate.send(ExchangeTypes.TOPIC, "test", new Message("Hello".getBytes()));

    }

}
