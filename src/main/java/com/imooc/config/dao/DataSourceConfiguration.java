package com.imooc.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * Created by rj on 18/2/27.
 */
@Configuration
//配置mybatis  mapper的扫描路径
@MapperScan("com.imooc.dao")
public class DataSourceConfiguration {
    @Value("${spring.datasource.driverClassName}")
    private String jdbcDriver;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String jdbcUsername;
    @Value("${spring.datasource.password}")
    private String jdbcPassword;


    @Bean(name = "dataSource")
    public ComboPooledDataSource createDataSoure() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        //关闭事务自动提交功能
        dataSource.setAutoCommitOnClose(false);
        return dataSource;
    }
}
