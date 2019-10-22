package com.web.admin.common;

import com.web.admin.modules.sys.entity.po.SysUser;
import org.apache.shiro.SecurityUtils;

public class BaseController {
    public SysUser getUser(){
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }
}
