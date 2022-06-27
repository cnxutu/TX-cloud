package com.example.common.pojo.query;

import lombok.Data;

import java.util.List;

/**
 * 通过id集合删除通用
 *
 * @author xutu
 * @since 2022-06-27
 */
@Data
public class DeletedByIdListQuery {

    private List<Long> idList;

}
