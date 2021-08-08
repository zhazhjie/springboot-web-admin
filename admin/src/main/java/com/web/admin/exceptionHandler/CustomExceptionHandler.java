package com.web.admin.exceptionHandler;


import com.web.common.exception.WebException;
import com.web.common.utils.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public ResponseData handleWebException(WebException e) {
        log.error("业务异常", e);
        return ResponseData.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public ResponseData bindMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        if (null != fieldError) {
            return ResponseData.fail(500, fieldError.getDefaultMessage());
        }
        return ResponseData.fail(500, "参数错误");
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(code= HttpStatus.FORBIDDEN)
    public ResponseData handleUnauthorizedException(UnauthorizedException e) {
        return ResponseData.fail("没有权限");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(code= HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseData handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        return ResponseData.fail(String.format("不支持%s请求", e.getMethod()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public ResponseData handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return ResponseData.fail(400, "请求参数类型不匹配");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(code= HttpStatus.INTERNAL_SERVER_ERROR)
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
