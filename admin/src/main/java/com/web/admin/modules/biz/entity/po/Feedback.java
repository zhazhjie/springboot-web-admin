package com.web.admin.modules.biz.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.web.admin.common.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
* @author: zzj
* @date: 2020-01-20 16:19:41
*/
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("feedback")
public class Feedback extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
    * 内容
    */
    private String content;


    /**
     * 图片地址
     */
    private String imgUrl;


    /**
    * 状态：0未处理，1已处理
    */
    private Integer state;

}
