package com.springboot.springbootaop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AfterStartRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("===============================");
        System.out.println("hello");
        System.out.println("-------------------------------");
    }
}
