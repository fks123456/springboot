package com.fks.aspects;

import com.fks.bean.DBContextHolder;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DataSourceAop {
    @Pointcut("!@annotation(com.fks.annotations.Master) && execution(* com.fks.service..*.select*(..))")
    public void db1Pointcut() {

    }

    @Pointcut("@annotation(com.fks.annotations.Master) || execution(* com.fks.service..*.find*(..))")
    public void db2Pointcut() {

    }

    @Before("db1Pointcut()")
    public void useDb1() {
        DBContextHolder.DB1();
    }

    @Before("db2Pointcut()")
    public void useDb2() {
        DBContextHolder.DB2();
    }

}
