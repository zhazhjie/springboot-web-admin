package com.web.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.web.admin.modules.sys.entity.po.SysMenu;
import com.web.admin.modules.sys.mapper.SysMenuMapper;
import com.web.admin.modules.sys.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.admin.modules.sys.service.SysRoleMenuService;
import com.web.common.utils.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 权限管理 服务实现类
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@Service("SysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Autowired
    SysRoleMenuService sysRoleMenuService;

    @Override
    public List<SysMenu> listMenu(Map<String, Object> params) {
        return baseMapper.listMenu(params);
    }

    @Override
    public List<SysMenu> listUserMenu(Long userId, Integer type) {
        if (userId.equals(SysConstant.SUPER_ADMIN_ID)) {
            return baseMapper.selectList(new LambdaQueryWrapper<SysMenu>().eq(type != null, SysMenu::getMenuType, type));
        }
        return baseMapper.listUserMenu(userId, type);
    }

    @Override
    public void add(SysMenu sysMenu) {
        baseMapper.insert(sysMenu);
    }

    @Override
    public void update(SysMenu sysMenu) {
        baseMapper.updateById(sysMenu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        baseMapper.deleteById(id);
        sysRoleMenuService.deleteByMenuId(id);
    }
}
