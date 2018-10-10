package com.springboot.springbootaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserAccessAspect {

    @Pointcut("@annotation(com.springboot.springbootaop.aspect.UserAccess)")
    public void access() {

    }

    @Before("access()")
    public void before() throws Throwable {
        System.out.println("注解之前");
    }

    @Around("@annotation(userAccess)")
    public Object Around(ProceedingJoinPoint pjp, UserAccess userAccess) throws Throwable {
        System.out.println("second around:" + userAccess.des());
        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
