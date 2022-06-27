package com.example.springbootdemo.mybatis.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.mybatis.entity.TbOrder;
import com.example.springbootdemo.mybatis.entity.TestQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xutu
 * @since 2022-05-12
 */
public interface TbOrderMapper extends BaseMapper<TbOrder> {

    List<TbOrder> getPageListByQuery(Page page, @Param("query") TestQuery query);
}
