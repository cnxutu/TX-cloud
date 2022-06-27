package com.example.springbootdemo.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.common.pojo.vo.PageInfoVO;
import com.example.common.utils.PageUtil;
import com.example.springbootdemo.mybatis.entity.TbOrder;
import com.example.springbootdemo.mybatis.entity.TestQuery;
import com.example.springbootdemo.mybatis.mapper.TbOrderMapper;
import com.example.springbootdemo.mybatis.service.ITbOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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


    @Resource
    private TbOrderMapper orderMapper;

    @Override
    public PageInfoVO<List<TbOrder>> getMyOrderPageList(TestQuery query) {
        Page page = new Page(query.getCurrent(), query.getSize());
        List<TbOrder> pageList = new ArrayList<>();
        pageList = orderMapper.getPageListByQuery(page, query);
        return PageUtil.pageBuild(page.setRecords(pageList));
    }
}
