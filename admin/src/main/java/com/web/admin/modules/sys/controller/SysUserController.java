package com.web.admin.modules.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.web.admin.common.BaseController;
import com.web.admin.modules.sys.entity.dto.PasswordDTO;
import com.web.admin.modules.sys.entity.dto.SysUserDTO;
import com.web.admin.modules.sys.entity.dto.UserLoginDTO;
import com.web.admin.modules.sys.entity.po.SysUser;
import com.web.admin.modules.sys.service.SysUserService;
import com.web.admin.modules.sys.service.SysUserTokenService;
import com.web.common.utils.AssertUtil;
import com.web.common.utils.ResponseData;
import com.web.common.utils.SysConstant;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysUserTokenService sysUserTokenService;

    @GetMapping("/listPage")
    @RequiresPermissions("sys:user:list")
    public ResponseData listPage(@RequestParam Map<String, Object> params) {
        IPage iPage = sysUserService.listPage(params);
        return ResponseData.success(iPage);
    }

    @GetMapping("/info")
    public ResponseData info() {
        SysUserDTO sysUserDTO = new SysUserDTO();
        BeanUtils.copyProperties(getUser(),sysUserDTO);
        return ResponseData.success(sysUserDTO);
    }

    @PostMapping("/updateById")
    @RequiresPermissions("sys:user:update")
    public ResponseData update(@RequestBody @Valid SysUserDTO sysUserDTO) {
        sysUserDTO.setUpdateBy(getUser().getId());
        sysUserService.update(sysUserDTO);
        return ResponseData.success();
    }

    @PostMapping("/save")
    @RequiresPermissions("sys:user:add")
    public ResponseData add(@RequestBody @Valid SysUserDTO sysUserDTO) {
        sysUserDTO.setCreateBy(getUser().getId());
        sysUserService.add(sysUserDTO);
        return ResponseData.success(SysConstant.INITIAL_PASSWORD);
    }

    @GetMapping("/deleteById")
    @RequiresPermissions("sys:user:delete")
    public ResponseData delete(@RequestParam Long id) {
        sysUserService.removeById(id);
        return ResponseData.success();
    }

    @PostMapping("/resetPassword/{userId}")
    @RequiresPermissions("sys:user:resetPassword")
    public ResponseData resetPassword(@PathVariable Long userId) {
        sysUserService.resetPassword(userId);
        return ResponseData.success(SysConstant.INITIAL_PASSWORD);
    }

    @PostMapping("/updatePassword")
    @RequiresPermissions("sys:user:updatePassword")
    public ResponseData updatePassword(@RequestBody PasswordDTO passwordDTO) {
        AssertUtil.isTrue(getUser().getPassword().equals(new Sha256Hash(passwordDTO.getPassword(),getUser().getSalt()).toHex()),"原密码不正确");
        passwordDTO.setUserId(getUser().getId());
        sysUserService.updatePassword(passwordDTO);
        return ResponseData.success();
    }

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
