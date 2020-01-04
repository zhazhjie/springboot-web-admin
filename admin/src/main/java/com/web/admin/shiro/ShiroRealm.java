package com.web.admin.shiro;

import com.web.admin.modules.sys.entity.po.SysPermission;
import com.web.admin.modules.sys.entity.po.SysUser;
import com.web.admin.modules.sys.entity.po.SysUserToken;
import com.web.admin.modules.sys.service.SysPermissionService;
import com.web.admin.modules.sys.service.SysUserService;
import com.web.admin.modules.sys.service.SysUserTokenService;
import com.web.common.utils.SysConstant;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;
    @Autowired
    private SysUserTokenService sysUserTokenService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof ShiroToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principals.getPrimaryPrincipal();
        List<SysPermission> sysPermissions = sysPermissionService.listUserPermission(user.getId(), SysConstant.SysPermissionType.INTERFACE.getValue());
        Set<String> permsSet = new HashSet<>();
        sysPermissions.forEach(permission -> {
            permsSet.add(permission.getPermissionFlag());
        });
        authorizationInfo.setStringPermissions(permsSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        SysUserToken userToken = sysUserTokenService.getUserToken(token);
        if (userToken == null || userToken.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new IncorrectCredentialsException("登录失效，请重新登录");
        }
        SysUser user = sysUserService.getUserById(userToken.getUserId());
        // 账号被锁定
        if (SysConstant.NO.equals(user.getState())) {
            throw new LockedAccountException("账号已冻结,请联系管理员");
        }
        return new SimpleAuthenticationInfo(user, token, getName());
    }

}
