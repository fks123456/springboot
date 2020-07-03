package com.fks.config;

import com.fks.bean.DataSourceBean;
import com.fks.enums.DbTypeEnum;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class DatasourceConfig {

    @Value("${jdbc.driver1}")
    private String driver1;
    @Value("${jdbc.url1}")
    private String url1;
    @Value("${jdbc.user1}")
    private String user1;
    @Value("${jdbc.password1}")
    private String password1;

    @Value("${jdbc.driver2}")
    private String driver2;
    @Value("${jdbc.url2}")
    private String url2;
    @Value("${jdbc.user2}")
    private String user2;
    @Value("${jdbc.password2}")
    private String password2;

    @Bean("datasource1")
    public DataSource getDataSource1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver1);
        dataSource.setJdbcUrl(url1);
        dataSource.setUser(user1);
        dataSource.setPassword(password1);
        return dataSource;
    }

    @Bean("datasource2")
    public DataSource getDataSource2() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver2);
        dataSource.setJdbcUrl(url2);
        dataSource.setUser(user2);
        dataSource.setPassword(password2);
        return dataSource;
    }

    @Bean("myRoutingDataSource")
    public DataSource getMyRoutingDataSource(
            @Qualifier("datasource1") DataSource dataSource1,
            @Qualifier("datasource2") DataSource dataSource2) throws Exception {

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DbTypeEnum.DB1, dataSource1);
        targetDataSources.put(DbTypeEnum.DB2, dataSource2);

        DataSourceBean dataSourceBean = new DataSourceBean();
        dataSourceBean.setDefaultTargetDataSource(dataSource1);
        dataSourceBean.setTargetDataSources(targetDataSources);
        return dataSourceBean;
    }
}
