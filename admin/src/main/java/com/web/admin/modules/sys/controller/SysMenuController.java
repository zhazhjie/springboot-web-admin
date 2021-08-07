package com.web.admin.modules.sys.controller;


import com.web.admin.common.BaseController;
import com.web.admin.modules.sys.entity.po.SysMenu;
import com.web.admin.modules.sys.service.SysMenuService;
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
@RequestMapping("/sysMenu")
public class SysMenuController extends BaseController {
    @Autowired
    SysMenuService sysMenuService;

    @GetMapping("/listAll")
    @RequiresPermissions("sys:menu:list")
    public ResponseData listMenu(@RequestParam Map<String, Object> params) {
        List<SysMenu> sysMenus = sysMenuService.listMenu(params);
        return ResponseData.success(sysMenus);
    }

    @GetMapping("/listUserMenu")
//    @RequiresPermissions("sys:menu:list")
    public ResponseData listUserMenu() {
        Long userId = getUser().getId();
        List<SysMenu> userMenuList = sysMenuService.listUserMenu(userId, null);
        return ResponseData.success(userMenuList);
    }

    @PostMapping("/updateById")
    @RequiresPermissions("sys:menu:update")
    public ResponseData update(@RequestBody @Valid SysMenu sysMenu) {
        sysMenuService.update(sysMenu);
        return ResponseData.success();
    }

    @PostMapping("/save")
    @RequiresPermissions("sys:menu:add")
    public ResponseData add(@RequestBody @Valid SysMenu sysMenu) {
        sysMenuService.add(sysMenu);
        return ResponseData.success();
    }

    @GetMapping("/deleteById")
    @RequiresPermissions("sys:menu:delete")
    public ResponseData delete(@RequestParam Long id) {
        sysMenuService.removeById(id);
        return ResponseData.success();
    }
}
