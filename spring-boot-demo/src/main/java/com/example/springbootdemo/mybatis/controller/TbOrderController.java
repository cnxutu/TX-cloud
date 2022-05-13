package com.example.springbootdemo.mybatis.controller;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
//import com.example.incrementer.CustomIdGenerator;
//import com.example.springbootdemo.mybatis.config.CustomIdGenerator;
import com.example.springbootdemo.mybatis.constant.CrudRouteConstant;
import com.example.springbootdemo.mybatis.entity.TbOrder;
import com.example.springbootdemo.mybatis.mapper.TbOrderMapper;
import com.example.springbootdemo.mybatis.service.ITbOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author xutu
 * @since 2022-05-12
 */
@RestController
@RequestMapping("/order")
public class TbOrderController {

    @Resource
    private ITbOrderService tbOrderService;


//    @GetMapping("/pageList")
//    public Lis




    @GetMapping("/detail")
    public String detail() {
        TbOrder byId = tbOrderService.getById(1);
        return "";
    }



    @GetMapping("/edit")
    public String edit() {
        TbOrder tbOrder = new TbOrder();
        boolean b = tbOrderService.updateById(tbOrder);
        return "";
    }


    @GetMapping("/add")
    public String add() {
        TbOrder tbOrder = new TbOrder();
        boolean save = tbOrderService.save(tbOrder);
        return "";
    }


}
