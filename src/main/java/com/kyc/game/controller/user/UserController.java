package com.kyc.game.controller.user;

import com.kyc.game.common.Result;
import com.kyc.game.dao.tables.pojos.User;
import com.kyc.game.service.OssService;
import com.kyc.game.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private OssService ossService;

    @ResponseBody
    @GetMapping("/profile")
    public Result<User> getProfile() {
        return new Result<User>().setData(userService.getProfile());
    }

    @PostMapping("/avatar")
    @ResponseBody
    public Result<String> avatar(@RequestParam("avatarfile") MultipartFile file){
        Result<String> rs = new Result<>();
        if (!file.isEmpty()) {
            String path = ossService.uploadFile(file);
            if (path != null && userService.updateUserAvatar(path)) {
                rs.setData(path);
                return rs;
            }
        }
        return rs.error("上传图片异常，请联系管理员");
    }
}
