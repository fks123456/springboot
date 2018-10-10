package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        System.out.println("进入了index方法");
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("进入了hello方法");
        return "hello";
    }
}
