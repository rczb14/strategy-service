package com.kyc.game.controller.user;


import com.alibaba.fastjson2.JSONObject;
import com.kyc.game.common.Result;
import com.kyc.game.dao.tables.pojos.User;
import com.kyc.game.service.UserService;
import com.kyc.game.utils.CaptchaImageUtils;
import com.kyc.game.vo.user.LoginVO;
import com.kyc.game.vo.user.UserInfo;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    UserService userService;

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginVO vo) {
        Result<String> rs = new Result<>();
        String token = "";
        if (vo.getType().equals("1")) {
            //用户名密码登录
            userService.checkCaptcha(vo.getUuid(), vo.getCode());
            token = userService.login(vo.getUsername(), vo.getPassword());
        } else {
            //手机号+短信验证码登录
            userService.checkCaptcha(vo.getPhoneNumber(), vo.getCode());
            token = userService.login(vo.getPhoneNumber());
        }
        rs.ok(token);
        return rs;
    }

    @GetMapping("/logout/{token}")
    public void logout(@PathVariable String token) {
        userService.logout(token);
    }

    @PostMapping("/register")
    public Result<String> register(@RequestBody User user) {
        Result<String> rs = new Result<>();
        userService.register(user);
        rs.ok();
        return rs;
    }

    @GetMapping("/getInfo")
    public Result<UserInfo> getInfo() {
        Result<UserInfo> rs = new Result<>();
        UserInfo userInfo = userService.getInfo();
        return rs.setData(userInfo);
    }

    @GetMapping("/getCode")
    public void getCode(String phoneNumber) {
        userService.getCaptcha(phoneNumber);
    }

    @GetMapping("/captchaImage")
    public Result<JSONObject> captchaImage() {
        JSONObject jsonObject = CaptchaImageUtils.drawImage();
        String uuid = UUID.randomUUID().toString();
        //保存当前验证码
        redisTemplate.opsForValue().set(uuid, jsonObject.getString("code"), 60, TimeUnit.SECONDS);
        Result<JSONObject> res = new Result<>();
        jsonObject.put("uuid", uuid);
        return res.setData(jsonObject);
    }
}
