package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.service.HelloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Reference(version = "${demo.service.version}",
            application = "${dubbo.application.id}")
            // 直连需要配置url
            // url = "dubbo://localhost:12345")
    private HelloService helloService;

    @RequestMapping("/say/{name}")
    public String say(@PathVariable("name") String name) {
        return helloService.say(name);
    }
}
