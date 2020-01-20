package com.web.admin.modules.biz.service.impl;

import com.web.admin.modules.biz.entity.po.Feedback;
import com.web.admin.modules.biz.mapper.FeedbackMapper;
import com.web.admin.modules.biz.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
* @author: zzj
* @date: 2020-01-20 16:19:41
*/
@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public void save(Feedback feedback) {
        feedbackMapper.insert(feedback);
    }
}
