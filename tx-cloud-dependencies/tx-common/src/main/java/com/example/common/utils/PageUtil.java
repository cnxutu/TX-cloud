package com.example.common.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.pojo.vo.PageInfoVO;

/**
 * 分页工具
 */
public class PageUtil {

    /**
     * 按Page构建
     *
     * @param page {@link Page}
     * @return
     */
    public static PageInfoVO pageBuild(Page page) {
        PageInfoVO myPage = new PageInfoVO();
        myPage.setCurrent(page.getCurrent());
        myPage.setPages(page.getPages());
        myPage.setRecords(page.getRecords());
        myPage.setTotal(page.getTotal());
        myPage.setSize(page.getSize());
        return myPage;
    }


}
