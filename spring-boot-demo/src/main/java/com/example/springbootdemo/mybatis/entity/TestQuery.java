package com.example.springbootdemo.mybatis.entity;

import com.example.common.pojo.query.PageQuery;
import javax.validation.constraints.NotNull;
public class TestQuery extends PageQuery {


    @NotNull(message = "参数1不能为空！")
    private Integer param1;
}
