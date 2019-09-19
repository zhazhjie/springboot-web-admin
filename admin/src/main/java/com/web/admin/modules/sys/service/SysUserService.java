package com.web.admin.modules.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.web.admin.modules.sys.entity.dto.SysUserDTO;
import com.web.admin.modules.sys.entity.po.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
public interface SysUserService extends IService<SysUser> {
    IPage listPage(Map<String, Object> params);

    void add(SysUserDTO sysUserDTO);

    void update(SysUserDTO sysUserDTO);

    void delete(List<Long> ids);

    SysUser getUserByUsername(String username);

    SysUser getUserById(Long id);

    void resetPassword(Long userId);

    String login(Long userId);
}
