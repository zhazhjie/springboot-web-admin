package com.web.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.web.admin.modules.sys.entity.po.SysRoleMenu;
import com.web.admin.modules.sys.mapper.SysRoleMenuMapper;
import com.web.admin.modules.sys.service.SysRoleMenuService;
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
@Service("SysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {
    @Override
    public void deleteByMenuId(Long permissionId) {
        baseMapper.delete(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getMenuId, permissionId));
    }

    @Override
    public void deleteByRoleId(Long roleId) {
        baseMapper.delete(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getRoleId, roleId));
    }

    @Override
    public void saveRoleMenu(Long roleId, List<Long> permissionIds) {
        if (permissionIds == null || permissionIds.size() == 0) return;
        ArrayList<SysRoleMenu> sysRoleMenuList = new ArrayList<>();
        permissionIds.forEach(permissionId -> {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setId(IdWorker.getId());
            sysRoleMenu.setRoleId(roleId);
            sysRoleMenu.setMenuId(permissionId);
            sysRoleMenu.setCreateTime(new Date());
            sysRoleMenuList.add(sysRoleMenu);
        });
        baseMapper.saveRoleMenu(sysRoleMenuList);
    }
}
