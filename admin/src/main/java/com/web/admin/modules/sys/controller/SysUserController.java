package com.web.admin.modules.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.web.admin.common.BaseController;
import com.web.admin.modules.sys.entity.dto.SysUserDTO;
import com.web.admin.modules.sys.entity.po.SysUser;
import com.web.admin.modules.sys.service.SysUserService;
import com.web.common.utils.SysConstant;
import com.web.common.utils.ResponseData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {
    @Autowired
    SysUserService sysUserService;

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

    @PostMapping("/update")
    @RequiresPermissions("sys:user:update")
    public ResponseData update(@RequestBody @Valid SysUserDTO sysUserDTO) {
        sysUserDTO.setUpdateBy(getUser().getId());
        sysUserService.update(sysUserDTO);
        return ResponseData.success();
    }

    @PutMapping("/add")
    @RequiresPermissions("sys:user:add")
    public ResponseData add(@RequestBody @Valid SysUserDTO sysUserDTO) {
        sysUserDTO.setCreateBy(getUser().getId());
        sysUserService.add(sysUserDTO);
        return ResponseData.success(SysConstant.INITIAL_PASSWORD);
    }

    @DeleteMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public ResponseData delete(@RequestBody List<Long> ids) {
        sysUserService.delete(ids);
        return ResponseData.success();
    }

    @PostMapping("/resetPassword/{userId}")
    @RequiresPermissions("sys:user:resetPassword")
    public ResponseData resetPassword(@PathVariable Long userId) {
        sysUserService.resetPassword(userId);
        return ResponseData.success(SysConstant.INITIAL_PASSWORD);
    }

}
