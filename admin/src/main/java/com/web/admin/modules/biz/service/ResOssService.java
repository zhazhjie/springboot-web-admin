package com.web.admin.modules.biz.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.web.admin.modules.biz.entity.dto.MoveGroupDTO;
import com.web.admin.modules.biz.entity.po.ResOss;
import java.util.List;
import java.util.Map;

/**
 * 资源对象存储
 *
 * @author zzj
 * @date 2019/02/19
 */
public interface ResOssService{

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
     IPage listPage(Map<String, Object> params);
    /**
     * 通过ID更新
     *
     * @param resOss
     */
    void updateById(ResOss resOss);

    /**
     * 通过ID逻辑删除
     *
     * @param ids
     */
    void deleteById(List<Long> ids);

    /**
     * 移动分组
     *
     * @param moveGroupDTO
     */
    void moveGroup(MoveGroupDTO moveGroupDTO);

    void saveResOss(ResOss resOss);
}
