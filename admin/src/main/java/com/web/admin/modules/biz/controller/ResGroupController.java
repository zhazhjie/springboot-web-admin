package com.web.admin.modules.biz.controller;

import com.web.admin.modules.biz.entity.po.ResGroup;
import com.web.admin.modules.biz.service.ResGroupService;
import com.web.common.utils.ResponseData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author zzj
 * @date 2019-02-15
 */
@RestController
@RequestMapping("/resGroup")
public class ResGroupController {

    @Autowired
    private ResGroupService resGroupService;

    @RequestMapping("/list")
    public ResponseData list(@RequestParam Map<String, Object> params) {
        return ResponseData.success(resGroupService.list(params));
    }

    @GetMapping("/getById")
    public ResponseData getById(Long id) {
        return ResponseData.success(resGroupService.getById(id));
    }

    @PostMapping("/updateById")
    @RequiresPermissions("res:group:update")
    public ResponseData updateById(@RequestBody ResGroup resGroup) {
        resGroupService.updateById(resGroup);
        return ResponseData.success();
    }

    @PostMapping("/save")
    @RequiresPermissions("res:group:save")
    public ResponseData save(@RequestBody ResGroup resGroup) {
        resGroupService.save(resGroup);
        return ResponseData.success();
    }

    @PostMapping("/deleteById/{id}")
    @RequiresPermissions("res:group:delete")
    public ResponseData deleteById(@PathVariable Long id) {
        resGroupService.deleteById(id);
        return ResponseData.success();
    }

}
