package com.example;


import cn.hutool.core.lang.generator.UUIDGenerator;
import com.example.springbootdemo.mybatis.entity.TbOrder;
import com.example.springbootdemo.mybatis.mapper.TbOrderMapper;
import com.example.springbootdemo.mybatis.service.ITbOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.UUID;

@SpringBootTest
class SpringBootDemoApplicationTests {


    @Resource
    private ITbOrderService orderService;

    @Resource
    private TbOrderMapper orderMapper;


}
