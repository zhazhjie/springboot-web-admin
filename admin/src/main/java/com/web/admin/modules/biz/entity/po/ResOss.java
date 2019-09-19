package com.web.admin.modules.biz.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.web.admin.common.BaseModel;
import lombok.Data;

/**
 *
 * @author zzj
 * @date 2019/02/19
 */
@Data
@TableName("res_oss")
public class ResOss extends BaseModel {

	private static final long serialVersionUID = 1L;



 	/**
	 * 资源类型ID
	 */
    @TableField("res_type")
	private String resType;

 	/**
	 * 分组ID
	 */
    @TableField("group_id")
	private Long groupId;

 	/**
	 * 对象url
	 */
    @TableField("obj_url")
	private String objUrl;

 	/**
	 * 后缀
	 */
    @TableField("obj_suffix")
	private String objSuffix;

 	/**
	 * 别名
	 */
    @TableField("alias_name")
	private String aliasName;

 	/**
	 * 排序号
	 */
    @TableField("sort")
	private Integer sort;



}
