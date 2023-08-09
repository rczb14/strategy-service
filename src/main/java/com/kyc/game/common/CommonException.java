package com.kyc.game.common;

public class CommonException extends RuntimeException {
    private String message;

    public CommonException(String message) {
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
