package com.web.admin.common;

import com.web.common.exception.WebException;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Slf4j
public class FileUtils {
    private static String WORKSPACE = "/workspace";
    private static  String PATH_PREFIX = "/cache/upload/images/";

    public static String saveFile(InputStream inputStream, String base64, String fileName) {
        File file = null;
        //创建文件目录
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = simpleDateFormat.format(date) + "/";
        String filePath = WORKSPACE + PATH_PREFIX + format;
        File dir = new File(filePath);
        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdirs();
        }
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try {
            file = new File(filePath + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            if (inputStream != null) {
                byte[] bytes = new byte[1024];
                while (inputStream.read(bytes) != -1) {
                    bos.write(bytes);
                }
            } else {
                byte[] bytes = Base64.getDecoder().decode(base64);
                bos.write(bytes);
            }
            return PATH_PREFIX + format + fileName;
        } catch (Exception e) {
            log.error("上传失败：{}", e);
            throw new WebException("上传失败！");
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
