package com.sangeng.service;

import com.sangeng.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    ResponseResult uploadImg(MultipartFile img);
}
