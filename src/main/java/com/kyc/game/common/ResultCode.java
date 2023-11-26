package com.kyc.game.common;

public enum ResultCode {

    SUCCESS(0, "成功"),
    UNKNOWN_ERROR(-1, "未知错误"),
    ERROR_LOGIN(100, "登录错误"),
    ERROR_LOGIN_USERNAME_NOT_EXISTS(ERROR_LOGIN.getCode() + 1, "用户不存在！"),
    ERROR_LOGIN_USERNAME_EXISTS(ERROR_LOGIN.getCode() + 2, "用户已存在！"),
    ERROR_LOGIN_PASSWORD_ERROR(ERROR_LOGIN.getCode() + 3, "密码错误！"),
    ERROR_LOGIN_GET_CODE(ERROR_LOGIN.getCode() + 4, "获取验证码失败！"),
    ERROR_LOGIN_CODE(ERROR_LOGIN.getCode() + 5, "验证码错误！"),
    ERROR_LOGIN_CODE_AFTER_TIME(ERROR_LOGIN.getCode() + 6, "验证码已过期！");

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private final int code;

    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static String from(int code) {
        for (ResultCode r : ResultCode.values()) {
            if (r.getCode() == code) {
                return r.getMessage();
            }
        }
        return UNKNOWN_ERROR.message;
    }
}
