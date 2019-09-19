package com.web.admin.modules.sys.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.web.admin.common.BaseModel;
import lombok.Data;

/**
 * <p>
 * 用户角色关系表
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@Data
@TableName("sys_user_role")
public class SysUserRole extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;


}
