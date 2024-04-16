package com.zzq.dubbo_provider.service;

import com.zzq.dubbo_interface.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class DubboApiImpl implements DemoService {

    public String sayHello(String name) {
        return "hello " + name;
    }
}
