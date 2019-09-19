package com.web.admin.modules.biz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web.admin.modules.biz.entity.dto.MoveGroupDTO;
import com.web.admin.modules.biz.entity.po.ResOss;
import com.web.admin.modules.biz.mapper.ResOssMapper;
import com.web.admin.modules.biz.service.ResOssService;
import com.web.admin.utils.PageWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 资源对象存储
 *
 * @author zzj
 * @date 2019/02/19
 */
@Service("resOssService")
@Slf4j
public class ResOssServiceImpl implements ResOssService {

    @Autowired
    private ResOssMapper resOssMapper;

    @Override
    public IPage listPage(Map<String, Object> params) {
        String groupId = (String) params.get("groupId");
        String resType = (String) params.get("resType");
        String keywords = (String) params.get("keywords");
        IPage<ResOss> resOssIPage = resOssMapper.selectPage(
                new PageWrapper<ResOss>(params).getPage(),
                new QueryWrapper<ResOss>()
                        .eq("res_type", resType)
                        .eq(StringUtils.isNotEmpty(groupId), "group_id", groupId)
                        .like(StringUtils.isNotEmpty(keywords), "alias_name", keywords)
                        .orderByDesc("id")
        );
        return resOssIPage;
    }

    @Override
    public void updateById(ResOss resOss) {
        resOssMapper.updateById(resOss);
    }

    @Override
    public void deleteById(List<Long> ids) {
        resOssMapper.deleteBatchIds(ids);
    }

    @Override
    public void moveGroup(MoveGroupDTO moveGroupDTO) {
        Long targetGroup = moveGroupDTO.getTargetGroup();
        List<Long> ids = moveGroupDTO.getIds();
        ids.forEach(id -> {
            ResOss resOss = new ResOss();
            resOss.setId(Long.valueOf(id));
            resOss.setGroupId(Long.valueOf(targetGroup));
            resOssMapper.updateById(resOss);
        });
    }

    @Override
    public void saveResOss(ResOss resOss) {
        resOssMapper.insert(resOss);
    }
}
