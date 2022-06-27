package com.example.common.handler;

import com.example.common.enums.ErrorCodeEnum;
import com.example.common.exception.CustomBusinessException;
import com.example.common.pojo.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 全局统一异常处理
 *
 * @author xutu
 * @since 2022-06-27
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomBusinessException.class)
    public Result CustomBusinessException(CustomBusinessException e) {
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 请求方式错误
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Result requestMethodNotSupported(HttpRequestMethodNotSupportedException e) {
        log.error("------------请求方式错误，method：{}", e.getMethod());
        return Result.fail(ErrorCodeEnum.REQUEST_METHOD_NOT_SUPPORTED);
    }

    /**
     * 路径不存在
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerNoFoundException(NoHandlerFoundException e) {
        log.error("------------路径不存在，httpMethod：{}，requestURL：{}", e.getHttpMethod(), e.getRequestURL());
        return Result.fail(ErrorCodeEnum.NO_HANDLER_FOUND);
    }

    /**
     * 处理Get请求中 使用 @Valid 验证路径中请求实体校验失败后抛出的异常
     */
    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException ex) {
        Map<String, Object> model = ex.getModel();
        Field[] modelNames = model.get(ex.getBindingResult().getObjectName()).getClass().getDeclaredFields();
        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        List<FieldError> fieldError = ex.getFieldErrors();
        List<ObjectError> resultError = new ArrayList<>();
        for (Field field : modelNames) {
            for (FieldError temp : fieldError) {
                if (temp.getField().equals(field.getName())) {
                    resultError.add(temp);
                }
            }
        }
        String errorInfo = resultError.get(0).getDefaultMessage();
        return Result.fail(ErrorCodeEnum.REQUEST_PARAM_ERROR, errorInfo);
    }

    /**
     * 捕获json绑定异常：@RequestBody
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result handleBindException(MethodArgumentNotValidException ex) {
        String defaultMessage = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        return Result.fail(ErrorCodeEnum.REQUEST_PARAM_ERROR.getCode(), defaultMessage);
    }

    /**
     * 处理请求参数格式错误 @RequestParam 上 validate 失败后抛出的异常是 javax.validation.ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public Result constraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return Result.fail(ErrorCodeEnum.REQUEST_PARAM_ERROR.getCode(), message);
    }


    /**
     * 未捕获的异常
     */
    @ExceptionHandler({RuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public Result unexpectedException(RuntimeException e) {
        log.error("========================================运行时异常：", e);
        return Result.fail(ErrorCodeEnum.SERVER_ERROR.getCode(), "服务器开小差了，请稍后再试");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Result consException(HttpMessageNotReadableException e) {
        String message = e.getMessage();
        // 防止Long类型和Integer类型越界
        // Numeric value (-7270469799016028) out of range of int
        if (StringUtils.isNotBlank(message) && message.contains("Numeric value (")) {
            log.error("========================================Long类型和Integer类型越界：{}", e.getMessage());
            return Result.fail(ErrorCodeEnum.REQUEST_PARAM_ERROR, "参数非法，请检查");
        }
        // org.springframework.http.converter.HttpMessageNotReadableException: Required request body is missing:
        if (StringUtils.isNotBlank(message) && message.contains("Required request body is missing")) {
            log.error("========================================post 请求 body 参数没传：{}", e.getMessage());
            return Result.fail(ErrorCodeEnum.REQUEST_PARAM_ERROR, "参数不能为空，请检查");
        }
        log.error("========================================传参格式错误：", e);
        return Result.fail(ErrorCodeEnum.REQUEST_PARAM_ERROR, "参数非法，请检查");
    }

}
