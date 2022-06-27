package com.example.common.pojo.vo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 简单分页封装
 *
 * @param <T>
 * @author xutu
 * @since 2022-06-27
 */
public class PageInfoVO<T> implements Serializable {

    /**
     * 总数
     */
    private Long total;

    /**
     * 每页显示条数
     */
    private Long size;

    /**
     * 总页数
     */
    private Long pages;

    /**
     * 当前页
     */
    private Long current;
    /**
     * 当前数据返回
     */
    private List<T> records = Collections.emptyList();

    public Long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Long getPages() {
        if (null == size || size == 0) {
            return 0L;
        }
        this.pages = this.total / this.size;
        if (this.total % this.size != 0) {
            this.pages++;
        }
        return this.pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    /**
     * 当前数据返回
     *
     * @return
     */
    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    /**
     * 分页数据
     *
     * @param total
     * @param size
     * @param pages
     * @param current
     * @param records
     */
    public PageInfoVO(Long total, Long size, Long pages, Long current, List<T> records) {
        this.total = total;
        this.size = size;
        this.pages = pages;
        this.current = current;
        this.records = records;
    }

    /**
     * 分页数据
     */
    public PageInfoVO() {

    }
}
