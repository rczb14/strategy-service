package com.kyc.game.common;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Result<T> {

    private int code;

    private String message;

    private T data;

    private List<T> rows;

    private String meno;

    public Result() {
        code = 0;
    }

    public void ok(T data) {
        this.code = 0;
        this.data = data;
    }

    public void error(String message) {
        this.code = -1;
        this.message = message;
    }
}
