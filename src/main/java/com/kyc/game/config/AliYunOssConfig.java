package com.kyc.game.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.kyc.game.service.ConfigService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class AliYunOssConfig {

    //定义公开静态常量
    public static String END_POINT;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    private static OSS ossClient;

    @Resource
    ConfigService configService;

    private void initOssClient() {
        END_POINT = configService.getConfig("ossEndPoint");
        ACCESS_KEY_ID = configService.getConfig("ossKeyId");
        ACCESS_KEY_SECRET = configService.getConfig("ossKeySecret");
        BUCKET_NAME = configService.getConfig("ossBucketName");
        ossClient = new OSSClientBuilder().build(END_POINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
    }

    public static OSS getOssClient() {
        if (ossClient == null) {
            new AliYunOssConfig().initOssClient();
        }
        return ossClient;
    }


}
