package com.zzq.learn_nacos_discovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@Controller
public class LearnNacosDiscoveryConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnNacosDiscoveryConsumerApplication.class, args);
    }
    
    @Autowired
    private RestTemplate restTemplate;

    private final static String providerName = "service-provider";

    @ResponseBody
    @GetMapping("hello")
    public String hello() {
        String url = "http://" + providerName + "/hello";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return "service-provider say: " + response.getBody();
    }

}
