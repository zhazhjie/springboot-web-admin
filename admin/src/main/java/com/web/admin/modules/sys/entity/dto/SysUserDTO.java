package com.web.admin.modules.sys.entity.dto;

import com.web.admin.common.BaseModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 * 系统用户
 * </p>
 *
 * @author zzj
 * @since 2019-09-04
 */
@Data
public class SysUserDTO extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String username;

    /**
     * 密码
     */
//    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 盐
     */
//    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 状态  1：正常   0：禁用
     */
    private Integer state;

    /**
     * 是否已删除 0：未删除 1：已删除
     */
//    private Integer delFlag;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 更新人
     */
    private Long updateBy;

    private List<Long> roleIdList;
}
