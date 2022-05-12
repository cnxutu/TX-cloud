package com.example.springbootdemo.mybatis.controller;

import com.example.springbootdemo.mybatis.entity.TbOrder;
import com.example.springbootdemo.mybatis.mapper.TbOrderMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xutu
 * @since 2022-05-12
 */
@Controller
@RequestMapping("/tbOrder")
public class TbOrderController {


    @Resource
    private TbOrderMapper orderMapper;


    @GetMapping("/hello")
    public String test01(){

        TbOrder tbOrder = orderMapper.selectById(1);

        System.out.println(tbOrder);


        return "";
    }


}
