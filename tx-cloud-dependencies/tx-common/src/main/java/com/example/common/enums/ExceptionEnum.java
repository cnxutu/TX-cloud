package com.example.common.enums;

/**
 * 异常编码接口
 *
 * @author xutu
 * @since 2022-06-27
 */
public interface ExceptionEnum {

    /**
     * 返回异常编码
     *
     * @return 异常编码
     */
    String getCode();

    /**
     * 返回异常消息
     *
     * @return 异常消息
     */
    String getMessage();

}
