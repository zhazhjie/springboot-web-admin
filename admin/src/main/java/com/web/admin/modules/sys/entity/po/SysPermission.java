package com.web.admin.modules.sys.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.web.admin.common.BaseModel;
import lombok.Data;

/**
 * <p>
 *  权限管理
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@Data
@TableName("sys_permission")
public class SysPermission extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 父节点ID，顶级为0
     */
    private Long parentId;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 菜单对应组件的路径或接口URL
     */
    private String url;

    /**
     * 授权标识 (如：sys:user:list)
     */
    private String permissionFlag;

    /**
     * 类型 0：菜单，1：接口
     */
    private Integer type;

    /**
     * 菜单图标 (类型为菜单时选填)
     */
    private String icon;

    /**
     * 状态 0 正常 1禁用
     */
    private Integer state;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 在导航菜单中隐藏 1 隐藏，0 显示 (类型为菜单时选填)
     */
    private Integer hidden;

}
