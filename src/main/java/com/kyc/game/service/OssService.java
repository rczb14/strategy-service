package com.kyc.game.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    /**
     * 文件上传至阿里云oss
     *
     * @param file 文件
     * @return 文件路径
     */
    String uploadFile(MultipartFile file);
}
