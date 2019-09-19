package com.web.admin.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web.admin.modules.sys.entity.po.SysPermission;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 权限管理 服务类
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
public interface SysPermissionService extends IService<SysPermission> {
    List<SysPermission> listPermission(Map<String, Object> params);

    List<SysPermission> listUserPermission(Long userId,Integer type);

    void add(SysPermission sysPermission);

    void update(SysPermission sysPermission);

    void delete(Long id);
}
