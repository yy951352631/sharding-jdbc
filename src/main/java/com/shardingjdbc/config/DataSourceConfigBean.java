package com.shardingjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author Wtq
 * @date 2019/10/12 - 9:48
 */
//@Configuration
//public class DataSourceConfigBean {
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource druidDataSource(){
//        return new DruidDataSource();
//    }
//}
