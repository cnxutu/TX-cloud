//package com.example.config;
//
//import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
//import com.example.incrementer.CustomIdGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//public class MyBatisPlusConfig {
//
//
//    /**
//     * idGenerator 雪花算法+UUID（不含中划线）
//     * @return
//     */
//    @Bean
//    public MybatisPlusPropertiesCustomizer plusPropertiesCustomizer() {
//        return plusProperties -> plusProperties.getGlobalConfig().setIdentifierGenerator(new CustomIdGenerator());
//    }
//}
