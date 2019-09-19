package com.web.common.exception;

import lombok.Data;

@Data
public class WebException extends RuntimeException {

    private String message;

    private int code = 500;

    public WebException(String message) {
        super(message);
        this.message = message;
    }

    public WebException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    public WebException(int code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public WebException(int code, String message, Throwable e) {
        super(message, e);
        this.message = message;
        this.code = code;
    }
}
