package com.zzq.learn_nacos_config.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigLoad {

    /**
     * 添加bootstrap.yml 写入基本配置 [需要依赖spring-cloud-starter-bootstrap]
     * <p>
     * 在Nacos配置中心添加${prefix}-${spring.profiles.active}.${file-extension}文件 [Data ID]
     * ex. config-service.yaml << test: test2
     * <p>
     * 项目启动会从配置中心拉取配置文件
     * <p>
     * RefreshScope 可以动态刷新配置
     */
    @Value("${test}")
    private String test;

    @GetMapping("hello")
    public String hello() {
        return test;
    }

}
