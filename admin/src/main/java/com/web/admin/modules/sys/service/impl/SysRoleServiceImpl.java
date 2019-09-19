package com.web.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.web.admin.modules.sys.entity.po.SysRole;
import com.web.admin.modules.sys.entity.po.SysUserRole;
import com.web.admin.modules.sys.mapper.SysRoleMapper;
import com.web.admin.modules.sys.service.SysRolePermissionService;
import com.web.admin.modules.sys.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.admin.modules.sys.service.SysUserRoleService;
import com.web.admin.utils.PageWrapper;
import com.web.common.utils.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@Service("SysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Autowired
    SysUserRoleService sysUserRoleService;
    @Autowired
    SysRolePermissionService sysRolePermissionService;

    @Override
    public List<SysRole> list(Long userId) {
        List<SysRole> sysRoles = baseMapper.selectList(null);
        return sysRoles;
    }

    @Override
    public IPage<SysRole> listPage(Map<String, Object> params) {
        PageWrapper<SysRole> pageWrapper = new PageWrapper<>(params);
        params.put("curPage", (pageWrapper.getCurrent() - 1) * pageWrapper.getSize());
        params.put("limit",pageWrapper.getSize());
        List<SysRole> sysRoles = baseMapper.listRole(params);
        Integer total = baseMapper.countRole(params);
        Page<SysRole> page = pageWrapper.getPage();
        page.setTotal(total);
        page.setRecords(sysRoles);
        return page;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysRole sysRole) {
        baseMapper.insert(sysRole);
        sysRolePermissionService.saveRolePermission(sysRole.getId(),sysRole.getPermissionIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRole sysRole) {
        baseMapper.updateById(sysRole);
        sysRolePermissionService.deleteByRoleId(sysRole.getId());
        sysRolePermissionService.saveRolePermission(sysRole.getId(),sysRole.getPermissionIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(List<Long> ids) {
        ids.forEach(id -> {
            List<SysUserRole> byRoleId = sysUserRoleService.getByRoleId(id);
            AssertUtil.isFalse(byRoleId.size() > 0, "该角色已被使用，不能删除");
            baseMapper.deleteById(id);
            sysRolePermissionService.deleteByRoleId(id);
        });
    }
}
