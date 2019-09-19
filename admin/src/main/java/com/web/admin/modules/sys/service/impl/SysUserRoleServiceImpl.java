package com.web.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.web.admin.modules.sys.entity.po.SysUserRole;
import com.web.admin.modules.sys.mapper.SysUserRoleMapper;
import com.web.admin.modules.sys.service.SysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@Service("SysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    @Override
    public void saveUserRole(Long userId, List<Long> roleIds) {
        if (roleIds == null) return;
        roleIds.forEach(roleId -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setRoleId(roleId);
            sysUserRole.setUserId(userId);
            baseMapper.insert(sysUserRole);
        });
    }

    @Override
    public void deleteByUserId(Long userId) {
        baseMapper.delete(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, userId));
    }

    @Override
    public List<SysUserRole> getByRoleId(Long roleId) {
        return baseMapper.selectList(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getRoleId, roleId));
    }
}
