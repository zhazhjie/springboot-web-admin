package com.web.admin.modules.sys.controller;


import com.web.admin.common.BaseController;
import com.web.admin.modules.sys.entity.po.SysPermission;
import com.web.admin.modules.sys.service.SysPermissionService;
import com.web.common.utils.SysConstant;
import com.web.common.utils.ResponseData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 权限管理 前端控制器
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@RestController
@RequestMapping("/sys/permission")
public class SysPermissionController extends BaseController {
    @Autowired
    SysPermissionService sysPermissionService;

    @GetMapping("/list")
    @RequiresPermissions("sys:permission:list")
    public ResponseData listPermission(@RequestParam Map<String, Object> params) {
        List<SysPermission> sysPermissions = sysPermissionService.listPermission(params);
        return ResponseData.success(sysPermissions);
    }

    @GetMapping("/listUserPermission")
    @RequiresPermissions("sys:permission:list")
    public ResponseData listUserMenu(@RequestParam Map<String, Object> params) {
        Long userId=getUser().getId();
        List<SysPermission> userMenuList = sysPermissionService.listUserPermission(userId, SysConstant.SysPermissionType.MENU.getValue());
        List<SysPermission> userPermissions = sysPermissionService.listUserPermission(userId, SysConstant.SysPermissionType.INTERFACE.getValue());
        List<String> userPermissionList = userPermissions.stream().map(item -> item.getPermissionFlag()).collect(Collectors.toList());
        HashMap<String, Object> result = new HashMap<>();
        result.put("menuList",userMenuList);
        result.put("permissions",userPermissionList);
        return ResponseData.success(result);
    }

    @PostMapping("/update")
    @RequiresPermissions("sys:permission:update")
    public ResponseData update(@RequestBody @Valid SysPermission sysPermission) {
        sysPermissionService.update(sysPermission);
        return ResponseData.success();
    }

    @PutMapping("/add")
    @RequiresPermissions("sys:permission:add")
    public ResponseData add(@RequestBody @Valid SysPermission sysPermission) {
        sysPermissionService.add(sysPermission);
        return ResponseData.success();
    }

    @DeleteMapping("/delete/{id}")
    @RequiresPermissions("sys:permission:delete")
    public ResponseData delete(@PathVariable Long id) {
        sysPermissionService.delete(id);
        return ResponseData.success();
    }
}
