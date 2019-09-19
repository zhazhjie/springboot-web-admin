package com.web.admin.exceptionHandler;


import com.web.common.exception.WebException;
import com.web.common.utils.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

/**
 * 自定义异常拦截
 *
 * @author zzj
 * @date 2019/9/4 17:18
 */
@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * 业务异常
     */
    @ExceptionHandler(WebException.class)
    public ResponseData handleWebException(WebException e) {
        log.error("业务异常", e);
        return ResponseData.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseData bindMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        if (null != fieldError) {
            return ResponseData.fail(500, fieldError.getDefaultMessage());
        }
        return ResponseData.fail(500, "参数错误");
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseData handleUnauthorizedException(UnauthorizedException e) {
        return ResponseData.fail("没有权限");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseData handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return ResponseData.fail(String.format("不支持%s请求", e.getMethod()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseData handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseData.fail(500, "请求参数类型不匹配");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseData handleConstraintViolationException(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
        return ResponseData.fail(500, iterator.next().getMessage());
    }

    /**
     * 其他未定义异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseData handleException(Exception e) {
        log.error("系统异常", e);
        return ResponseData.fail(500, "系统异常");
    }
}
