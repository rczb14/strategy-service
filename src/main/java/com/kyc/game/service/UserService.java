package com.kyc.game.service;

import com.kyc.game.dao.tables.pojos.User;

public interface UserService {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     */
    int login(String username, String password);

    /**
     * 登录
     *
     * @param phoneNumber 手机号
     * @param captcha     验证码
     */
    int login(String phoneNumber, int captcha);

    /**
     * 登录
     *
     * @param user 用户信息
     */
    int register(User user);

    /**
     * 获取验证码
     *
     * @param phoneNumber 手机号码
     */
    void getCaptcha(String phoneNumber);
}
