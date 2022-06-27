package com.example.common.pojo.po;


import com.baomidou.mybatisplus.annotation.TableField;
import com.example.common.utils.IdGenerator;
import com.example.common.utils.RequestUtil;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * PO基类
 *
 * @author xutu
 * @since 2022-06-27
 */
@Data
public class BasePO implements Serializable {
    private Long id;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 创建者信息
     */
    private Long creator;

    /**
     * 修改者信息
     */
    private Long operator;

    /**
     * 删除标识，0 表示未删除，1 表示删除
     */
    @TableField("is_deleted")
    private Integer isDeleted = 0;

    /**
     * 插入记录时初始化字段信息
     */
    public void initDateForInsert() {

        Date now = new Date();
        Long userId = RequestUtil.getRequestUserId();
        this.id = IdGenerator.generateId();
        this.setCreateTime(now);
        this.setUpdateTime(now);
        this.setCreator(userId);
        this.setOperator(userId);
    }

    /**
     * 更新记录时初始化字段信息
     */
    public void initDateForUpdate() {

        this.setUpdateTime(new Date());
        this.setOperator(RequestUtil.getRequestUserId());
    }


    /**
     * 插入记录时初始化字段信息(不需要token校验)
     */
    public void initDateForInsertNoAuth() {

        Date now = new Date();
        this.id = IdGenerator.generateId();
        this.setCreateTime(now);
        this.setUpdateTime(now);
    }

    /**
     * 更新记录时初始化字段信息(不需要token校验)
     */
    public void initDateForUpdateNoAuth() {

        this.setUpdateTime(new Date());
    }
}
