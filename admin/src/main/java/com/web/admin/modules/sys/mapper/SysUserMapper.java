package com.web.admin.modules.sys.mapper;

import com.web.admin.modules.sys.entity.po.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<SysUser> listUser(@Param("params") Map<String, Object> params);

    Integer countUser(@Param("params") Map<String, Object> params);
}
