package com.kyc.game.controller;


import com.alibaba.fastjson2.JSONObject;
import com.kyc.game.common.Result;
import com.kyc.game.common.ResultCode;
import com.kyc.game.dao.tables.pojos.User;
import com.kyc.game.service.UserService;
import com.kyc.game.utils.CaptchaImageUtils;
import com.kyc.game.vo.LoginVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    private static Map<String, String> map = new HashMap<>();

    @PostMapping("/login")
    @ResponseBody
    public Result<String> login(@RequestBody LoginVO vo) {
        Result<String> rs = new Result<>();
        int code = 0;
        String captcha = map.get(vo.getUuid());
        if (vo.getType().equals("1")) {
            if (!captcha.equals(String.valueOf(vo.getCode()))) {
                code = ResultCode.ERROR_LOGIN_CODE.getCode();
            } else {
                code = userService.login(vo.getUsername(), vo.getPassword());
            }
        } else {
            code = userService.login(vo.getPhoneNumber(), vo.getCode());
        }
        return rs.setCode(code).setMessage(ResultCode.from(code));
    }

    @PostMapping("/register")
    @ResponseBody
    public Result<String> register(@RequestBody User user) {
        Result<String> rs = new Result<>();
        int code = userService.register(user);
        return rs.setCode(code).setMessage(ResultCode.from(code));
    }

    @GetMapping("/getCode")
    @ResponseBody
    public void getCode(String phoneNumber) {
        userService.getCaptcha(phoneNumber);
    }

    @GetMapping("/captchaImage")
    @ResponseBody
    public Result<JSONObject> captchaImage() {
        JSONObject jsonObject = CaptchaImageUtils.drawImage();
        String uuid = UUID.randomUUID().toString();
        map.put(uuid, jsonObject.getString("code"));
        Result<JSONObject> res = new Result<>();
        jsonObject.put("uuid", uuid);
        return res.setData(jsonObject);
    }
}
