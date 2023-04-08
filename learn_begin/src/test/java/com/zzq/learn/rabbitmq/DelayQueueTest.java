package com.zzq.learn.rabbitmq;

import com.zzq.learn.mq.rabbitmq.QueueEnum;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.annotation.Resource;

@SpringBootTest
public class DelayQueueTest {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send() {
        rabbitTemplate.convertAndSend(QueueEnum.TTL_QUEUE.getExchangeName(), QueueEnum.TTL_QUEUE.getRoutingKey(), new Message("Hello".getBytes()), new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                MessageProperties messageProperties = message.getMessageProperties();
                messageProperties.setExpiration(String.valueOf(1000 * 60 * 5));
                return message;
            }
        });
    }
}
