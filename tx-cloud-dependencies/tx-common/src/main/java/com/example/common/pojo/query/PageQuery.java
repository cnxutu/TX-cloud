package com.example.common.pojo.query;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页入参继承该类
 *
 * @author xutu
 * @since 2022-06-27
 */
@Getter
@Setter
public class PageQuery {

    private static final int MAX_PAGE_SIZE = 50;

    /**
     * 当前页数，第一页值为1
     */
    private Integer current;
    /**
     * 每页的条数，默认最大值为50
     */
    private Integer size;


    public Integer getCurrent() {
        if (null == current || current <= 0) {
            return 1;
        }
        return current;
    }

    public Integer getSize() {
        if (null == size || size <= 0) {
            return 10;
        }
        if (size >= MAX_PAGE_SIZE) {
            return MAX_PAGE_SIZE;
        }
        return size;
    }
}
