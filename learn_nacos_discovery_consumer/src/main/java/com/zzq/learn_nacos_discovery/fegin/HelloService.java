package com.zzq.learn_nacos_discovery.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("service-provider")
public interface HelloService {

    @GetMapping("hello")
    String hello();
}
