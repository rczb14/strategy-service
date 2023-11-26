package com.kyc.game.vo.user;

import lombok.Data;

@Data
public class LoginVO {
    //登录类型（1：用户名密码；2：手机号）
    private String type;
    //用户名
    private String username;
    //密码
    private String password;
    //手机号
    private String phoneNumber;
    //图片验证码key
    private String uuid;
    //输入验证码值
    private String code;
}
