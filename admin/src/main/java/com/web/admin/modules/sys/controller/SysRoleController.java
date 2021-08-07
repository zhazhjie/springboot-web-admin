package com.web.admin.modules.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.web.admin.common.BaseController;
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
@RequestMapping("/sysRole")
public class SysRoleController extends BaseController {
    @Autowired
    SysRoleService sysRoleService;

    @GetMapping("/listAll")
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

    @PostMapping("/updateById")
    @RequiresPermissions("sys:role:update")
    public ResponseData update(@RequestBody @Valid SysRole sysRole) {
        sysRoleService.update(sysRole);
        return ResponseData.success();
    }

    @PostMapping("/save")
    @RequiresPermissions("sys:role:add")
    public ResponseData add(@RequestBody @Valid SysRole sysRole) {
        sysRoleService.add(sysRole);
        return ResponseData.success();
    }

    @GetMapping("/deleteById")
    @RequiresPermissions("sys:role:delete")
    public ResponseData delete(@RequestParam Long id) {
        sysRoleService.removeById(id);
        return ResponseData.success();
    }
}
