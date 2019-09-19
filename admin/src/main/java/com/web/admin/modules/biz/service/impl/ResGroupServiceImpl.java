package com.web.admin.modules.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.web.admin.modules.biz.entity.po.ResGroup;
import com.web.admin.modules.biz.entity.po.ResOss;
import com.web.admin.modules.biz.mapper.ResGroupMapper;
import com.web.admin.modules.biz.mapper.ResOssMapper;
import com.web.admin.modules.biz.service.ResGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 资源分组
 *
 * @author zzj
 * @date 2019/02/19
 */
@Service("resGroupService")
@Slf4j
public class ResGroupServiceImpl implements ResGroupService {

    @Autowired
    private ResGroupMapper resGroupMapper;
    @Autowired
    private ResOssMapper resOssMapper;

    @Override
    public List<ResGroup> list(Map<String, Object> params) {
        String resType = (String) params.get("resType");
        return resGroupMapper.selectList(new QueryWrapper<ResGroup>().eq("res_type",resType));
    }

    @Override
    public ResGroup getById(Long id) {
        return resGroupMapper.selectById(id);
    }

    @Override
    public void save(ResGroup resGroup) {
        resGroupMapper.insert(resGroup);
    }

    @Override
    public void updateById(ResGroup resGroup) {
        resGroupMapper.updateById(resGroup);
    }

    @Override
    public void deleteById(Long id) {
        resGroupMapper.deleteById(id);
        ResOss resOss = new ResOss();
        resOss.setGroupId(0L);
        resOssMapper.update(resOss,new QueryWrapper<ResOss>().eq("group_id",id));
    }
}
