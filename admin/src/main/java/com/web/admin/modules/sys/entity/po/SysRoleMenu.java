package com.web.admin.modules.sys.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.web.admin.common.BaseModel;
import lombok.Data;

/**
 * <p>
 * 角色权限关系表
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@Data
@TableName("sys_role_menu")
public class SysRoleMenu extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID
     */
    private Long menuId;


}
