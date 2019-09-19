package com.web.admin.modules.sys.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.web.admin.common.BaseModel;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 系统用户Token
 * </p>
 *
 * @author zzj
 * @since 2019-09-11
 */
@Data
@TableName("sys_user_token")
public class SysUserToken extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long userId;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private Date expireTime;


}
