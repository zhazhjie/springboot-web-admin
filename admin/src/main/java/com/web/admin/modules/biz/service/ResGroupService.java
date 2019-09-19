package com.web.admin.modules.biz.service;



import com.web.admin.modules.biz.entity.po.ResGroup;
import java.util.List;
import java.util.Map;

/**
 * 资源分组
 *
 * @author zzhihong
 * @date 2019/02/19
 */
public interface ResGroupService {

    /**
     * 查询所有
     *
     * @return
     */
    List<ResGroup> list(Map<String, Object> params);

    /**
     * 通过ID查询
     *
     * @param id
     * @return
     */
    ResGroup getById(Long id);

    /**
     * 新增保存
     *
     * @param productInfoModel
     */
    void save(ResGroup productInfoModel);

    /**
     * 通过ID更新
     *
     * @param productInfoModel
     */
    void updateById(ResGroup productInfoModel);

    /**
     * 通过ID逻辑删除
     *
     * @param id
     */
    void deleteById(Long id);

}
