package com.web.admin.modules.sys.mapper;

import com.web.admin.modules.sys.entity.po.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色权限关系表 Mapper 接口
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    void saveRoleMenu(@Param("SysRoleMenuList") List<SysRoleMenu> SysRoleMenuList);
}
