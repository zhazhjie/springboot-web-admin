package com.web.admin.modules.sys.mapper;

import com.web.admin.modules.sys.entity.po.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> listRole(@Param("params") Map<String, Object> params);

    Integer countRole(@Param("params") Map<String, Object> params);
}
