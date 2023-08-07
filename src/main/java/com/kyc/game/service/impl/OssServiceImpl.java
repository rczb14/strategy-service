package com.kyc.game.service.impl;

import com.aliyun.oss.OSS;
import com.kyc.game.config.AliYunOssConfig;
import com.kyc.game.service.OssService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            OSS ossClient = AliYunOssConfig.getOssClient();
            String endpoint = AliYunOssConfig.END_POINT;
            String bucketName = AliYunOssConfig.BUCKET_NAME;

            InputStream inputStream = file.getInputStream();
            //获取文件名称
            String fileName = file.getOriginalFilename();
            //在文件名称里边添加一个随机唯一的值
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            fileName = uuid + fileName;
            //文件按日期分类存到oss
            //获取当前的日期
            String datePath = new DateTime().toString("yyyy/MMM/dd");
            fileName = datePath + "/" + fileName;

            ossClient.putObject(bucketName, fileName, inputStream);
            ossClient.shutdown();
            //返回路径
            return "https://" + bucketName + "." + endpoint + "/" + fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
