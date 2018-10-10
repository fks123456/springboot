package com.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.service.HelloService;

@Service(
        version = "${demo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String name) {
        return "Hello " + name;
    }
}
