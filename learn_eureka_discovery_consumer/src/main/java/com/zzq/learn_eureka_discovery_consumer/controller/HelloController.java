package com.zzq.learn_eureka_discovery_consumer.controller;

import com.zzq.learn_eureka_discovery_consumer.feign.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    private final static String providerName = "eureka-provider";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HelloService helloService;

    @GetMapping("hello")
    public String hello() {
        return "consumer say: " + restTemplate.getForEntity("http://" + providerName + "/hello", String.class).getBody();
    }

    @GetMapping("feignHello")
    public String feignHello() {
        return "consumer say: " + helloService.hello();
    }

}
