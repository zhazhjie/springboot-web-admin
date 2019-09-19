package com.web.common.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * controller层返回值
 *
 * @param <T>
 */
@Data
public class ResponseData<T> implements Serializable {
    private Integer code;
    private String message;
    private Long timestamp;
    private T data;

    private static Integer SUCCESS_CODE = 200;
    private static String SUCCESS_MESSAGE = "成功";

    private static Integer FAIL_CODE = 500;
    private static String FAIL_MESSAGE = "失败";

    public ResponseData(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResponseData success(T data) {
        return new ResponseData<>(SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    public static ResponseData success() {
        return success(null);
    }

    public static ResponseData fail() {
        return fail(FAIL_CODE, FAIL_MESSAGE);
    }

    public static ResponseData fail(String message) {
        return fail(FAIL_CODE, message);
    }

    public static ResponseData fail(Integer code, String message) {
        return new ResponseData<>(code, message, null);
    }
}
