package com.web.admin.modules.biz.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResOssDTO implements Serializable {
    private Long groupId;
    private String name;
    private String urlData;
}
