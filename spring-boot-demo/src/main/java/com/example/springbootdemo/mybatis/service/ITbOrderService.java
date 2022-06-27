package com.example.springbootdemo.mybatis.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.pojo.vo.PageInfoVO;
import com.example.springbootdemo.mybatis.entity.TbOrder;
import com.example.springbootdemo.mybatis.entity.TestQuery;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xutu
 * @since 2022-05-12
 */
public interface ITbOrderService extends IService<TbOrder> {
    PageInfoVO<List<TbOrder>> getMyOrderPageList(TestQuery query);


    /**
     *
     *
     *
     *
     *
     */


}
