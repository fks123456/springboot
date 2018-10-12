package com.springboot.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

    // 处理为访问未授权url
    @ExceptionHandler(value = AuthorizationException.class)
    public String handler(HttpServletRequest req, Exception e) {
        return "/unauthorized.html";
    }
}
