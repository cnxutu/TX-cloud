package com.example.springbootdemo.clickhouse.config;


import com.clickhouse.jdbc.ClickHouseConnection;
import com.clickhouse.jdbc.ClickHouseDataSource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Configuration
@Order(-1)
@Slf4j
public class ClickHouseConfig {

    @Value("${spring.clickhouse.url}")
    private String url;

    @Value("${spring.clickhouse.user}")
    private String user;

    @Value("${spring.clickhouse.password}")
    private String password;



//    @Bean
//    public ClickHouseDataSource initializeDataSource() throws Exception {
//        try {
//            return DriverManager.getConnection(url, user, password);
//        }catch (Exception e){
//            log.error("初始化clickhouse数据库失败......");
//        }
//        return null;
//    }

}
