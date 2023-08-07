package com.kyc.game.vo;

import lombok.Data;

@Data
public class LoginVO {
    private String type;
    private String username;
    private String password;
    private String phoneNumber;
    private String uuid;
    private int code;
}
