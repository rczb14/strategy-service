package com.kyc.game.service.impl;

import com.kyc.game.common.ResultCode;
import com.kyc.game.dao.tables.daos.UserDao;
import com.kyc.game.dao.tables.pojos.User;
import com.kyc.game.eneity.CodeMessage;
import com.kyc.game.service.UserService;
import com.kyc.game.utils.SMSUtils;
import jakarta.annotation.Resource;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    DSLContext dsl;

    @Resource
    UserDao userDao;

    com.kyc.game.dao.tables.User userT = com.kyc.game.dao.tables.User.USER;

    private static final Map<String, CodeMessage> codeMap = new HashMap<>(16);

    SimpleDateFormat sdf = new SimpleDateFormat();

    @Override
    public int login(String username, String password) {
        User user = dsl.selectFrom(userT).where(userT.USERNAME.eq(username)).fetchOneInto(User.class);
        if (user == null) {
            return ResultCode.ERROR_LOGIN_USERNAME_NOT_EXISTS.getCode();
        }
        if (password.equals(user.getPassword())) {
            return ResultCode.SUCCESS.getCode();
        } else {
            return ResultCode.ERROR_LOGIN_PASSWORD_ERROR.getCode();
        }
    }

    @Override
    public int login(String phoneNumber, int captcha) {
        User user = dsl.selectFrom(userT).where(userT.MOBILE.eq(phoneNumber)).fetchOneInto(User.class);
        if (user == null) {
            return ResultCode.ERROR_LOGIN_USERNAME_NOT_EXISTS.getCode();
        }
        CodeMessage codeMsg = codeMap.get(phoneNumber);
        if (codeMsg == null) {
            return ResultCode.ERROR_LOGIN_CODE.getCode();
        }
        long now = System.currentTimeMillis();
        long start = codeMsg.getTimeStamp();
        if (now - start > 60 * 1000) {
            return ResultCode.ERROR_LOGIN_CODE_AFTER_TIME.getCode();
        }
        return ResultCode.SUCCESS.getCode();
    }

    @Override
    public int register(User user) {
        User u = dsl.selectFrom(userT).where(userT.USERNAME.eq(user.getUsername())).fetchOneInto(User.class);
        if (u != null) {
            return ResultCode.ERROR_LOGIN_USERNAME_EXISTS.getCode();
        }
        userDao.insert(user);
        return ResultCode.SUCCESS.getCode();
    }

    @Override
    public void getCaptcha(String phoneNumber) {
        CodeMessage codeMsg = codeMap.get(phoneNumber);
        if (codeMsg == null) {
            sendCaptcha(phoneNumber);
        } else {
            long now = System.currentTimeMillis();
            long start = codeMsg.getTimeStamp();
            if (now - start > 60 * 1000) {
                sendCaptcha(phoneNumber);
            }
        }

    }

    private void sendCaptcha(String phoneNumber) {
        int code = SMSUtils.sendMessage(phoneNumber);
        if (code != -1) {
            CodeMessage codeMessage = new CodeMessage(code, 0, System.currentTimeMillis());
            codeMap.put(phoneNumber, codeMessage);
        }
    }
}
