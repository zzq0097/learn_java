package com.zzq.learn.config.bean;

import com.zzq.learn.mq.rabbitmq.QueueEnum;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    // --- 正常队列

    @Bean
    public Queue directQueue() {
        return new Queue(QueueEnum.QUEUE.getQueueName(), true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(QueueEnum.QUEUE.getExchangeName(), true, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(QueueEnum.QUEUE.getRoutingKey());
    }

    // --- TTL 延迟队列
    @Bean
    public Queue ttlQueue() {
        return QueueBuilder
                .durable(QueueEnum.TTL_QUEUE.getQueueName())
                .deadLetterExchange(QueueEnum.DEAD_QUEUE.getExchangeName())
                .deadLetterRoutingKey(QueueEnum.DEAD_QUEUE.getRoutingKey())
                .build();
    }

    @Bean
    public DirectExchange ttlExchange() {
        return new DirectExchange(QueueEnum.TTL_QUEUE.getExchangeName(), true, false);
    }

    @Bean
    public Binding ttlBinding() {
        return BindingBuilder.bind(ttlQueue()).to(ttlExchange()).with(QueueEnum.TTL_QUEUE.getRoutingKey());
    }

    // --- DEAD 死信队列
    @Bean
    public Queue deadQueue() {
        return new Queue(QueueEnum.DEAD_QUEUE.getQueueName(), true);
    }

    @Bean
    public DirectExchange deadExchange() {
        return new DirectExchange(QueueEnum.DEAD_QUEUE.getExchangeName(), true, false);
    }

    @Bean
    public Binding deadBinding() {
        return BindingBuilder.bind(deadQueue()).to(deadExchange()).with(QueueEnum.DEAD_QUEUE.getRoutingKey());
    }

}
