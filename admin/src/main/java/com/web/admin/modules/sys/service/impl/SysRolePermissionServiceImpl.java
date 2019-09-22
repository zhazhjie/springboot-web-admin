package com.web.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.web.admin.modules.sys.entity.po.SysRolePermission;
import com.web.admin.modules.sys.mapper.SysRolePermissionMapper;
import com.web.admin.modules.sys.service.SysRolePermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 角色权限关系表 服务实现类
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@Service("SysRolePermissionService")
public class SysRolePermissionServiceImpl extends ServiceImpl<SysRolePermissionMapper, SysRolePermission> implements SysRolePermissionService {
    @Override
    public void deleteByPermissionId(Long permissionId) {
        baseMapper.delete(new LambdaQueryWrapper<SysRolePermission>().eq(SysRolePermission::getPermissionId, permissionId));
    }

    @Override
    public void deleteByRoleId(Long roleId) {
        baseMapper.delete(new LambdaQueryWrapper<SysRolePermission>().eq(SysRolePermission::getRoleId, roleId));
    }

    @Override
    public void saveRolePermission(Long roleId, List<Long> permissionIds) {
        if (permissionIds == null || permissionIds.size() == 0) return;
        ArrayList<SysRolePermission> sysRolePermissionList = new ArrayList<>();
        permissionIds.forEach(permissionId -> {
            SysRolePermission sysRolePermission = new SysRolePermission();
            sysRolePermission.setId(IdWorker.getId());
            sysRolePermission.setRoleId(roleId);
            sysRolePermission.setPermissionId(permissionId);
            sysRolePermission.setCreateTime(new Date());
            sysRolePermissionList.add(sysRolePermission);
        });
        baseMapper.saveRolePermission(sysRolePermissionList);
    }
}
