package com.web.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.web.admin.modules.sys.entity.po.SysPermission;
import com.web.admin.modules.sys.mapper.SysPermissionMapper;
import com.web.admin.modules.sys.service.SysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.admin.modules.sys.service.SysRolePermissionService;
import com.web.common.utils.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  权限管理 服务实现类
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@Service("SysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements SysPermissionService {
    @Autowired
    SysRolePermissionService sysRolePermissionService;

    @Override
    public List<SysPermission> listPermission(Map<String, Object> params) {
        return baseMapper.listPermission(params);
    }

    @Override
    public List<SysPermission> listUserPermission(Long userId,Integer type) {
        if(userId.equals(SysConstant.SUPER_ADMIN_ID)){
            return baseMapper.selectList(new LambdaQueryWrapper<SysPermission>().eq(SysPermission::getType,type));
        }
        return baseMapper.listUserPermission(userId, type);
    }

    @Override
    public void add(SysPermission sysPermission) {
        baseMapper.insert(sysPermission);
    }

    @Override
    public void update(SysPermission sysPermission) {
        baseMapper.updateById(sysPermission);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        baseMapper.deleteById(id);
        sysRolePermissionService.deleteByPermissionId(id);
    }
}
