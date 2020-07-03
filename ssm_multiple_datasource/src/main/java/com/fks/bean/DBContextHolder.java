package com.fks.bean;

import com.fks.enums.DbTypeEnum;

public class DBContextHolder {

    private static final ThreadLocal<DbTypeEnum> contextHolder = new ThreadLocal<>();

    public static void set(DbTypeEnum dbType) {
        contextHolder.set(dbType);
    }

    public static DbTypeEnum get() {
        return contextHolder.get();
    }

    public static void DB1() {
        set(DbTypeEnum.DB1);
        System.out.println("切换到DB1");
    }

    public static void DB2() {
        set(DbTypeEnum.DB2);
        System.out.println("切换到DB2");
    }
}
