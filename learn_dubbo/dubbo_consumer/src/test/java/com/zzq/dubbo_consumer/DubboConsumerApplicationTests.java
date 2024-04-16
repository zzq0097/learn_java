package com.zzq.dubbo_consumer;

import com.zzq.dubbo_consumer.service.DubboConsumer;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DubboConsumerApplicationTests {
    @Resource
    DubboConsumer dubboConsumer;

    @Test
    void contextLoads() {
        System.out.println(dubboConsumer.call());
    }

}
