package com.web.common.utils;

import java.io.Serializable;

public class SysConstant implements Serializable {
    public static String INITIAL_PASSWORD = "123456";
    public static Long SUPER_ADMIN_ID = 1L;
    public static Integer LOGIN_EXPIRE_TIME = 2 * 60 * 60 * 1000;
    public static Integer YES = 1;
    public static Integer NO = 0;

    public enum SysMenuType {
        DIR(0, "目录"),
        MENU(1, "菜单"),
        BUTTON(2, "接口");
        private Integer value;
        private String label;

        SysMenuType(Integer value, String label) {
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
