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
@TableName("res_group")
public class ResGroup extends BaseModel {

	private static final long serialVersionUID = 1L;


	/**
	 * 资源类型ID
	 */
	@TableField("res_type")
	private String resType;

 	/**
	 * 分组名称
	 */
    @TableField("group_name")
	private String groupName;

 	/**
	 * 排序号
	 */
    @TableField("sort")
	private Integer sort;

}
