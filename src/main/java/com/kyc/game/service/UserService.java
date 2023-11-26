package com.kyc.game.service;

import com.kyc.game.dao.tables.pojos.User;
import com.kyc.game.vo.user.UserInfo;

public interface UserService {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     */
    String login(String username, String password);

    /**
     * 检查验证码
     *
     * @param captchaKey 验证码key
     * @param code       验证码值
     */
    void checkCaptcha(String captchaKey, String code);

    /**
     * 登录
     *
     * @param phoneNumber 手机号
     */
    String login(String phoneNumber);

    /**
     * 退出登录
     *
     * @param token token
     */
    void logout(String token);

    /**
     * 登录
     *
     * @param user 用户信息
     */
    void register(User user);

    /**
     * 获取用户信息
     */
    UserInfo getInfo();

    /**
     * 获取验证码
     *
     * @param phoneNumber 手机号码
     */
    void getCaptcha(String phoneNumber);

    /**
     * 获取用户个人信息
     */
    User getProfile();

    /**
     * 更新用户个人信息
     *
     * @param user 用户信息
     */
    void updateProfile(User user);

    /**
     * 修改密码
     *
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     */
    void updatePwd(String oldPassword, String newPassword);

    /**
     * 更新头像路径
     *
     * @param path 头像路径
     */
    boolean updateUserAvatar(String path);
}
