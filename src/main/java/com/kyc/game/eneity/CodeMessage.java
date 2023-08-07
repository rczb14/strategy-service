package com.kyc.game.eneity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CodeMessage {

    private int value;

    //0:生效 1:过期 2:待清除
    private int status;

    private long timeStamp;
}
