package com.example.springbootdemo.mybatis.controller;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusPropertiesCustomizer;
import com.example.springbootdemo.mybatis.constant.CrudRouteConstant;
import com.example.springbootdemo.mybatis.entity.TbOrder;
import com.example.springbootdemo.mybatis.mapper.TbOrderMapper;
import com.example.springbootdemo.mybatis.service.ITbOrderService;
import com.example.txmybatis.incrementer.CustomIdGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
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

//    @Resource
//    private MybatisPlusPropertiesCustomizer mybatisPlusPropertiesCustomizer;

    @Resource
    private CustomIdGenerator customIdGenerator;


    /**
     * // 根据 ID 查询
     * T getById(Serializable id);
     * // 根据 Wrapper，查询一条记录。结果集，如果是多个会抛出异常，随机取一条加上限制条件 wrapper.last("LIMIT 1")
     * T getOne(Wrapper<T> queryWrapper);
     * // 根据 Wrapper，查询一条记录
     * T getOne(Wrapper<T> queryWrapper, boolean throwEx);
     * // 根据 Wrapper，查询一条记录
     * Map<String, Object> getMap(Wrapper<T> queryWrapper);
     * // 根据 Wrapper，查询一条记录
     * <V> V getObj(Wrapper<T> queryWrapper, Function<? super Object, V> mapper);
     * @param route
     * @return
     */
    @GetMapping("/detail")
    public String detail(@RequestParam("route")Integer route){
         if (CrudRouteConstant.SERVICE_SELECT.intValue() == route){
             TbOrder router = tbOrderService.getById(1);
             return router.toString();

         }else if (CrudRouteConstant.MAPPER_SELECT.intValue() == route){



         }else {
             return "";
         }

        return "";
    }

    @GetMapping("/edit")
    public String edit(){
        Long aLong = customIdGenerator.nextId(TbOrder.class);
        return "";
    }


    /**
     * // 插入一条记录（选择字段，策略插入）
     * boolean save(T entity);
     * // 插入（批量）
     * boolean saveBatch(Collection<T> entityList);
     * // 插入（批量）
     * boolean saveBatch(Collection<T> entityList, int batchSize);
     * @return
     */
    @GetMapping("/add")
    public String add(){


        return "";
    }





}
