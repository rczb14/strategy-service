package com.kyc.game.controller;

import com.kyc.game.common.Result;
import com.kyc.game.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/oss")
@CrossOrigin
public class OssController {
    @Autowired
    private OssService ossService;

    @PostMapping(value = "/uploadFile", headers = "content-type=multipart/form-data")
    public Result<String> uploadOssFile(@RequestPart("file") MultipartFile file) {
        //返回上传到oss的路径
        Result<String> rs = new Result<>();
        String url = ossService.uploadFile(file);
        return rs.ok(url);
    }
}
