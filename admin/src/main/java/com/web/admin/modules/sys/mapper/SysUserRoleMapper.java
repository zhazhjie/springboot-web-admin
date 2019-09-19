package com.web.admin.modules.sys.mapper;

import com.web.admin.modules.sys.entity.po.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户角色关系表 Mapper 接口
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    void batchInsert(@Param("roleIds")List<Long> roleIds);
}
