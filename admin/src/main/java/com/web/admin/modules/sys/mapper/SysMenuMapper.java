package com.web.admin.modules.sys.mapper;

import com.web.admin.modules.sys.entity.po.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 权限管理 Mapper 接口
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    List<SysMenu> listMenu(@Param("params") Map<String, Object> params);
    List<SysMenu> listUserMenu(@Param("userId") Long id, @Param("type") Integer type);
}
