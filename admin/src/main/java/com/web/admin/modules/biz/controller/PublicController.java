package com.web.admin.modules.biz.controller;

import com.web.admin.common.FileUtils;
import com.web.common.exception.WebException;
import com.web.common.utils.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/public")
public class PublicController {

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    @RequiresPermissions("public:upload")
    public ResponseData upload(MultipartFile file) {
        String imagePattern = "(jpg|png|jpeg)";
        String fileName = file.getOriginalFilename();
        String suffix = "";
        if (StringUtils.isNotBlank(fileName)) {
            String[] ary = fileName.split("\\.");
            suffix = ary[ary.length - 1];
            if (ary.length <= 1 || !Pattern.matches(imagePattern, suffix)) {
                throw new WebException("图片格式错误");
            }
        }
        InputStream inputStream;
        try {
            inputStream = file.getInputStream();
        } catch (Exception e) {
            throw new WebException("上传图片异常");
        }
        String url = FileUtils.saveFile(inputStream, null, fileName);
        return ResponseData.success(url);
    }
}
