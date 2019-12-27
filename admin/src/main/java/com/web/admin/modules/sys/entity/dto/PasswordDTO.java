package com.web.admin.modules.sys.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PasswordDTO implements Serializable {
    private Long userId;
    private String password;
    private String newPassword;
}
