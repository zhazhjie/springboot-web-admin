package com.web.admin.modules.sys.service;

import com.web.admin.modules.sys.entity.po.SysRoleMenu;
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
public interface SysRoleMenuService extends IService<SysRoleMenu> {
    void deleteByMenuId(Long menuId);

    void deleteByRoleId(Long roleId);

    void saveRoleMenu(Long roleId, List<Long> menuIds);
}
