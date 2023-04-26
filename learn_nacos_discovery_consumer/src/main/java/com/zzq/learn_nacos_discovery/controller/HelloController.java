package com.zzq.learn_nacos_discovery.controller;

import com.zzq.learn_nacos_discovery.fegin.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HelloService helloService;

    private final static String providerName = "service-provider";

    @GetMapping("hello")
    public String hello() {
        String url = "http://" + providerName + "/hello";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return "service-provider say: " + response.getBody();
    }

    @GetMapping("feignHello")
    public String feignHello() {
        return "service-provider say: " + helloService.hello();
    }
}
