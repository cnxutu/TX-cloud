package com.example.springbootdemo.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.springbootdemo.mybatis.entity.TbOrder;
import com.example.springbootdemo.mybatis.mapper.TbOrderMapper;
import com.example.springbootdemo.mybatis.service.ITbOrderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xutu
 * @since 2022-05-12
 */
@Service
public class TbOrderServiceImpl extends ServiceImpl<TbOrderMapper, TbOrder> implements ITbOrderService {

}
