package com.kyc.game.common;

public class CommonException extends RuntimeException {

    private int code;
    private String message;

    public CommonException(String message) {
        this.code = -1;
        this.message = message;
    }

    public CommonException(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
