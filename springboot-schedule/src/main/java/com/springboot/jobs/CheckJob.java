package com.springboot.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckJob {
    @Scheduled(cron = "0 */1 * * * *")
    public void checkJob1() {
        System.out.println("启动检查工作1");
        System.out.println("结束检查工作1");
    }

    @Scheduled(cron = "0 */2 * * * *")
    public void checkJob2() {
        System.out.println("启动检查工作2");
        System.out.println("结束检查工作2");
    }
}
