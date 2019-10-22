package com.web.admin.modules.sys.controller;

import com.web.admin.common.BaseController;
import com.web.admin.modules.sys.entity.dto.UserLoginDTO;
import com.web.admin.modules.sys.entity.po.SysUser;
import com.web.admin.modules.sys.service.SysUserService;
import com.web.admin.modules.sys.service.SysUserTokenService;
import com.web.common.utils.AssertUtil;
import com.web.common.utils.ResponseData;
import com.web.common.utils.SysConstant;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys")
public class SysLoginController extends BaseController {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysUserTokenService sysUserTokenService;

    @PostMapping("/login")
    public ResponseData login(@RequestBody UserLoginDTO dto) {
        SysUser user = sysUserService.getUserByUsername(dto.getUsername());
        AssertUtil.notNull(user,"用户不存在");
        AssertUtil.isTrue(SysConstant.YES.equals(user.getState()),"账号已被锁定，请联系管理员");
        AssertUtil.isTrue(user.getPassword().equals(new Sha256Hash(dto.getPassword(),user.getSalt()).toHex()),"账号或密码不正确");
        String token = sysUserService.login(user.getId());
        return ResponseData.success(token);
    }

    @PostMapping("/logout")
    public ResponseData logout() {
        sysUserTokenService.deleteUserToken(getUser().getId());
        return ResponseData.success();
    }
}
