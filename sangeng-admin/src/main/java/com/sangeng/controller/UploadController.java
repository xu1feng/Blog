package com.sangeng.controller;

import com.sangeng.domain.ResponseResult;
import com.sangeng.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description:
 * @Author: 徐一峰
 * @Date: 2024/10/3
 **/

@RestController
@RequestMapping
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("/upload")
    public ResponseResult uploadImg(@RequestParam("img") MultipartFile file) {
        try {
            return uploadService.uploadImg(file);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("文件上传失败！");
        }
    }
}
