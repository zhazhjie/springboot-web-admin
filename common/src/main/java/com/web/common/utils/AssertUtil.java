package com.web.common.utils;

import com.web.common.exception.WebException;
import org.apache.commons.lang.StringUtils;

public class AssertUtil {
    public static <T> void notNull(T data, String message) {
        if (data == null) throw new WebException(message);
    }

    public static <T> void isNull(T data, String message) {
        if (data != null) throw new WebException(message);
    }

    public static void isTrue(boolean data, String message) {
        if (!data) throw new WebException(message);
    }

    public static void isFalse(boolean data, String message) {
        if (data) throw new WebException(message);
    }

    public static void notEmpty(String data, String message) {
        if (StringUtils.isEmpty(data)) throw new WebException(message);
    }

    public static void isEmpty(String data, String message) {
        if (StringUtils.isNotEmpty(data)) throw new WebException(message);
    }

}
