package com.zzq.learn_zookeeper_discovery_consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("provider")
public interface HelloService {

    @GetMapping("hello")
    String hello();
}
