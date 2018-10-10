package com.springboot.springbootaop.controller;

import com.springboot.springbootaop.aspect.UserAccess;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/index")
    @UserAccess(des = "index方法")
    public String index() {
        return "hello";
    }
}
