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

    public Result<T> ok(T data) {
        return new Result<T>().setCode(0).setData(data);
    }
}
