package com.web.admin.modules.sys.service;

import com.web.admin.modules.sys.entity.po.SysRolePermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色权限关系表 服务类
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
public interface SysRolePermissionService extends IService<SysRolePermission> {
    void deleteByPermissionId(Long permissionId);

    void deleteByRoleId(Long roleId);

    void saveRolePermission(Long roleId, List<Long> permissionIds);
}
