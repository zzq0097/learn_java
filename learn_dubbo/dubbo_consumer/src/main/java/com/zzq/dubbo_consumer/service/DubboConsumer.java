package com.zzq.dubbo_consumer.service;

import com.zzq.dubbo_interface.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class DubboConsumer {

    @DubboReference
    DemoService demoService;

    public String call() {
        return demoService.sayHello("zzq");
    }

}
