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

    @ResponseBody
    @PutMapping("/profile")
    public Result<String> updateProfile(@RequestBody User user) {
        Result<String> rs = new Result<>();
        try {
            userService.updateProfile(user);
            rs.ok("success");
        } catch (Exception e) {
            e.printStackTrace();
            rs.error("信息更新失败！");
        }
        return rs;
    }

    @ResponseBody
    @PutMapping("/updatePwd")
    public Result<String> updatePwd(String oldPassword, String newPassword) {
        Result<String> rs = new Result<>();
        try {
            userService.updatePwd(oldPassword, newPassword);
            rs.ok("success");
        } catch (Exception e) {
            rs.error(e.getMessage());
        }
        return rs;
    }

    @PostMapping("/avatar")
    @ResponseBody
    public Result<String> avatar(@RequestParam("avatarfile") MultipartFile file) {
        Result<String> rs = new Result<>();
        if (!file.isEmpty()) {
            String path = ossService.uploadFile(file);
            if (path != null && userService.updateUserAvatar(path)) {
                rs.setData(path);
                return rs;
            }
        }
        rs.error("上传图片异常，请联系管理员");
        return rs;
    }
}
