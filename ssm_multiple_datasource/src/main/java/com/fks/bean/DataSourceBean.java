package com.fks.bean;

import com.fks.enums.DbTypeEnum;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DataSourceBean extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        DbTypeEnum dbTypeEnum = DBContextHolder.get();
        return dbTypeEnum;
    }
}
