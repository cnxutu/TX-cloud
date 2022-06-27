package com.example.springbootdemo.mybatis.controller;


import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
//import com.example.incrementer.CustomIdGenerator;
//import com.example.springbootdemo.mybatis.config.CustomIdGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.enums.ErrorCodeEnum;
import com.example.common.exception.CustomBusinessException;
import com.example.common.pojo.query.PageQuery;
import com.example.common.pojo.vo.PageInfoVO;
import com.example.common.pojo.vo.Result;
import com.example.common.utils.PageUtil;
import com.example.springbootdemo.mybatis.constant.CrudRouteConstant;
import com.example.springbootdemo.mybatis.entity.TbOrder;
import com.example.springbootdemo.mybatis.entity.TestQuery;
import com.example.springbootdemo.mybatis.mapper.TbOrderMapper;
import com.example.springbootdemo.mybatis.service.ITbOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    private TbOrderMapper orderMapper;


    @PostMapping("/pageList")
    public Result<PageInfoVO<List<TbOrder>>> getPageList(@RequestBody @Validated TestQuery query) {
        PageInfoVO<List<TbOrder>> pageInfoVO = tbOrderService.getMyOrderPageList(query);
        return Result.succeed(pageInfoVO);
    }


    @GetMapping("/detail")
    public String detail() {
        TbOrder byId = tbOrderService.getById(1);
        return "";
    }


    @GetMapping("/edit")
    public Result edit(@RequestParam("param1") int param1) {
        TbOrder tbOrder = new TbOrder();
//        boolean b = tbOrderService.myUpdateById(tbOrder);
        if (param1 == 1) {
            throw new CustomBusinessException(ErrorCodeEnum.OPERATION_FAIL);
        }
        return Result.succeed();
    }


    @GetMapping("/add")
    public String add() {
        TbOrder tbOrder = new TbOrder();
        boolean save = tbOrderService.save(tbOrder);
        return "";
    }


}
