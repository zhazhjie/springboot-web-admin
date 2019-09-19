package com.web.common.utils;

import java.io.Serializable;

public class SysConstant implements Serializable {
    public static String INITIAL_PASSWORD = "123456";
    public static Long SUPER_ADMIN_ID = 1L;
    public static Integer LOGIN_EXPIRE_TIME = 2 * 60 * 60 * 1000;
    public static Integer YES = 1;
    public static Integer NO = 0;

    public enum SysPermissionType {
        MENU(0, "菜单"),
        INTERFACE(1, "接口");
        private Integer value;
        private String label;

        SysPermissionType(Integer value, String label) {
            this.value = value;
            this.label = label;
        }

        public Integer getValue() {
            return value;
        }

        public String getLabel() {
            return label;
        }
    }
}
