package com.web.admin.modules.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.web.admin.modules.sys.entity.po.SysRole;
import com.web.admin.modules.sys.service.SysRoleService;
import com.web.common.utils.ResponseData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {
    @Autowired
    SysRoleService sysRoleService;

    @GetMapping("/list")
    @RequiresPermissions("sys:role:list")
    public ResponseData list() {
        List<SysRole> list = sysRoleService.list(1L);
        return ResponseData.success(list);
    }

    @GetMapping("/listPage")
    @RequiresPermissions("sys:role:list")
    public ResponseData listPage(@RequestParam Map<String,Object> params) {
        IPage<SysRole> sysRoleIPage = sysRoleService.listPage(params);
        return ResponseData.success(sysRoleIPage);
    }

    @PostMapping("/update")
    @RequiresPermissions("sys:role:update")
    public ResponseData update(@RequestBody @Valid SysRole sysRole) {
        sysRoleService.update(sysRole);
        return ResponseData.success();
    }

    @PutMapping("/add")
    @RequiresPermissions("sys:role:add")
    public ResponseData add(@RequestBody @Valid SysRole sysRole) {
        sysRoleService.add(sysRole);
        return ResponseData.success();
    }

    @DeleteMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public ResponseData delete(@RequestBody List<Long> ids) {
        sysRoleService.delete(ids);
        return ResponseData.success();
    }
}
