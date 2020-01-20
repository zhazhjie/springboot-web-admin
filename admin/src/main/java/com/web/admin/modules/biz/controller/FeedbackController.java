package com.web.admin.modules.biz.controller;

import com.web.admin.modules.biz.entity.po.Feedback;
import com.web.admin.modules.biz.entity.po.ResGroup;
import com.web.admin.modules.biz.service.FeedbackService;
import com.web.common.utils.ResponseData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
* @author: zzj
* @date: 2020-01-20 16:19:41
*/
@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @PostMapping("/save")
    public ResponseData save(@RequestBody Feedback feedback) {
        feedbackService.save(feedback);
        return ResponseData.success();
    }
}
