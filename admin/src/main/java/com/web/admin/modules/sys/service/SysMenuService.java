package com.web.admin.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web.admin.modules.sys.entity.po.SysMenu;

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
public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> listMenu(Map<String, Object> params);

    List<SysMenu> listUserMenu(Long userId, Integer type);

    void add(SysMenu sysMenu);

    void update(SysMenu sysMenu);

    void delete(Long id);
}
