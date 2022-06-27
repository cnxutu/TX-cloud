package com.example.common.exception;

import com.example.common.enums.ErrorCodeEnum;
import com.example.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * 自定义业务异常类基类
 *
 * @author xutu
 * @since 2022-06-27
 */
@Data
public class CustomBusinessException extends RuntimeException {

    private String code;

    public CustomBusinessException(ErrorCodeEnum errorCodeEnum, String message) {
        super(message);
        this.code = errorCodeEnum.getCode();
    }

    public CustomBusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public CustomBusinessException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public CustomBusinessException(ExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }

    public CustomBusinessException(ExceptionEnum exceptionEnum, Throwable cause) {
        super(exceptionEnum.getMessage(), cause);
        this.code = exceptionEnum.getCode();
    }
}
