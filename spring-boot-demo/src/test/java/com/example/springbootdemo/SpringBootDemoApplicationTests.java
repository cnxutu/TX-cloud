package com.example.springbootdemo;

import com.example.springbootdemo.mybatis.entity.TbOrder;
import com.example.txmybatis.incrementer.CustomIdGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBootDemoApplicationTests {

    @Resource
    private CustomIdGenerator customIdGenerator;


    @Test
    void contextLoads() {
        Long aLong = customIdGenerator.nextId(TbOrder.class);

        System.out.println(aLong);


    }

}
