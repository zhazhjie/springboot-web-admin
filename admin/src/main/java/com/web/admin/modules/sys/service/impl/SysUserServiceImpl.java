package com.web.admin.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.web.admin.config.ShiroCacheManager;
import com.web.admin.modules.sys.entity.dto.SysUserDTO;
import com.web.admin.modules.sys.entity.po.SysUser;
import com.web.admin.modules.sys.mapper.SysUserMapper;
import com.web.admin.modules.sys.service.SysUserRoleService;
import com.web.admin.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.admin.modules.sys.service.SysUserTokenService;
import com.web.admin.utils.PageWrapper;
import com.web.common.utils.AssertUtil;
import com.web.common.utils.SysConstant;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@Service("SysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    SysUserRoleService sysUserRoleService;

    @Autowired
    SysUserTokenService sysUserTokenService;

    @Autowired
    ShiroCacheManager shiroCacheManager;

    @Override
    public IPage listPage(Map<String, Object> params) {
        PageWrapper<SysUser> pageWrapper = new PageWrapper<>(params);
        params.put("curPage", (pageWrapper.getCurrent() - 1) * pageWrapper.getSize());
        params.put("limit",pageWrapper.getSize());
        List<SysUser> sysUsers = baseMapper.listUser(params);
        Integer total = baseMapper.countUser(params);
        Page<SysUser> page = pageWrapper.getPage();
        page.setTotal(total);
        page.setRecords(sysUsers);
        return page;
    }

    @Override
    public void add(SysUserDTO sysUserDTO) {
        SysUser existUser = this.getUserByUsername(sysUserDTO.getUsername());
        AssertUtil.isNull(existUser,"用户已存在");
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserDTO,sysUser);
        String salt = RandomStringUtils.randomAlphanumeric(20);
        sysUser.setPassword(new Sha256Hash(SysConstant.INITIAL_PASSWORD, salt).toHex());
        sysUser.setSalt(salt);
        baseMapper.insert(sysUser);
        sysUserRoleService.saveUserRole(sysUser.getId(),sysUserDTO.getRoleIdList());
    }

    @Override
    public void update(SysUserDTO sysUserDTO) {
        SysUser existUser = this.getUserById(sysUserDTO.getId());
        AssertUtil.notNull(existUser,"用户不存在");
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserDTO,sysUser);
        baseMapper.updateById(sysUser);
        sysUserRoleService.deleteByUserId(sysUserDTO.getId());
        sysUserRoleService.saveUserRole(sysUser.getId(),sysUserDTO.getRoleIdList());
        shiroCacheManager.remove(existUser.toString());
    }

    @Override
    public void delete(List<Long> ids) {
        ids.forEach(id->{
            SysUser sysUser = new SysUser();
            sysUser.setId(id);
            sysUser.setDelFlag(1);
            baseMapper.updateById(sysUser);
        });
    }

    public void resetPassword(Long userId){
        SysUser sysUser = new SysUser();
        String salt = RandomStringUtils.randomAlphanumeric(20);
        sysUser.setPassword(new Sha256Hash(SysConstant.INITIAL_PASSWORD, salt).toHex());
        sysUser.setSalt(salt);
        sysUser.setId(userId);
        baseMapper.updateById(sysUser);
    }

    public SysUser getUserById(Long userId){
        return baseMapper.selectById(userId);
    }

    public SysUser getUserByUsername(String username){
        return baseMapper.selectOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername,username));
    }

    @Override
    public String login(Long userId) {
        return sysUserTokenService.buildLoginToken(userId);
    }
}
