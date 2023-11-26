package com.kyc.game.config.exception;

import com.kyc.game.common.CommonException;
import com.kyc.game.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.kyc")
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public Result<String> CommonExceptionHandler(CommonException e) {
        Result<String> rs = new Result<>();
        rs.error(e.getCode(), e.getMessage());
        return rs;
    }
}
