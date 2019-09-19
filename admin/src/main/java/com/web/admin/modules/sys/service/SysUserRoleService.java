package com.web.admin.modules.sys.service;

import com.web.admin.modules.sys.entity.po.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 服务类
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
public interface SysUserRoleService extends IService<SysUserRole> {
    void saveUserRole(Long userId, List<Long> roleIds);
    void deleteByUserId(Long userId);
    List<SysUserRole> getByRoleId(Long roleId);
}
