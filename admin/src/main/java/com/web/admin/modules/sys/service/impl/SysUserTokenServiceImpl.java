package com.web.admin.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.web.admin.modules.sys.entity.po.SysUserToken;
import com.web.admin.modules.sys.mapper.SysUserTokenMapper;
import com.web.admin.modules.sys.service.SysUserTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.common.utils.SysConstant;
import com.web.common.utils.TokenGenerator;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 系统用户Token 服务实现类
 * </p>
 *
 * @author zzj
 * @since 2019-09-11
 */
@Service
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenMapper, SysUserToken> implements SysUserTokenService {
    @Override
    public String buildLoginToken(Long userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        Date now = new Date();
        Date expireTime = new Date(now.getTime() + SysConstant.LOGIN_EXPIRE_TIME);
        SysUserToken userToken = baseMapper.selectOne(new LambdaQueryWrapper<SysUserToken>().eq(SysUserToken::getUserId, userId));
        if (userToken == null) {
            userToken = new SysUserToken();
            userToken.setUserId(userId);
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);
            baseMapper.insert(userToken);
        } else if (userToken.getExpireTime().getTime() < System.currentTimeMillis()) {
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);
            baseMapper.updateById(userToken);
        }
        return token;
    }

    @Override
    public SysUserToken getUserToken(String token) {
        return baseMapper.selectOne(new LambdaQueryWrapper<SysUserToken>().eq(SysUserToken::getToken, token));
    }

    @Override
    public void deleteUserToken(Long userId) {
        baseMapper.delete(new LambdaQueryWrapper<SysUserToken>().eq(SysUserToken::getUserId, userId));
    }
}
