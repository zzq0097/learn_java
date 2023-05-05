package com.zzzq.learn_zookeeper_discovery_consumer.controller;

import com.zzzq.learn_zookeeper_discovery_consumer.fegin.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HelloController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HelloService helloService;
    @Autowired
    private DiscoveryClient discoveryClient;

    private final static String providerName = "provider";
    
    @GetMapping("hello")
    public String hello() {
        List<ServiceInstance> instances = discoveryClient.getInstances(providerName);
        String url = instances.get(0).getUri().toString();
        return "consumer say: " + restTemplate.getForEntity(url + "/hello", String.class).getBody();
    }

    @GetMapping("loadBalancedHello")
    public String loadBalancedHello() {
        return "consumer say: " + restTemplate.getForEntity("http://" + providerName + "/hello", String.class).getBody();
    }

    @GetMapping("feignHello")
    public String feignHello() {
        return "consumer say: " + helloService.hello();
    }
}
