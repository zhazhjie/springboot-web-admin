package com.web.admin.modules.sys.service;

import com.web.admin.modules.sys.entity.po.SysUserToken;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户Token 服务类
 * </p>
 *
 * @author zzj
 * @since 2019-09-11
 */
public interface SysUserTokenService extends IService<SysUserToken> {
    String buildLoginToken(Long userId);
    SysUserToken getUserToken(String token);
    void deleteUserToken(Long userId);
}
