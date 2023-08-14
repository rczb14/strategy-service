package com.kyc.game.service.impl;

import com.kyc.game.common.CommonException;
import com.kyc.game.common.Constant;
import com.kyc.game.common.ResultCode;
import com.kyc.game.dao.tables.daos.UserDao;
import com.kyc.game.dao.tables.pojos.Role;
import com.kyc.game.dao.tables.pojos.User;
import com.kyc.game.eneity.CodeMessage;
import com.kyc.game.service.UserService;
import com.kyc.game.utils.BaseUtils;
import com.kyc.game.utils.SMSUtils;
import com.kyc.game.vo.user.UserInfo;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    DSLContext dsl;

    @Resource
    UserDao userDao;

    com.kyc.game.dao.tables.User userT = com.kyc.game.dao.tables.User.USER;

    com.kyc.game.dao.tables.Role roleT = com.kyc.game.dao.tables.Role.ROLE;

    private static final Map<String, CodeMessage> codeMap = new HashMap<>(16);

    SimpleDateFormat sdf = new SimpleDateFormat();

    private static Map<String, Long> tokens = new HashMap<>();

    @Override
    public int login(String username, String password) {
        User user = dsl.selectFrom(userT).where(userT.USERNAME.eq(username)).fetchOneInto(User.class);
        if (user == null) {
            return ResultCode.ERROR_LOGIN_USERNAME_NOT_EXISTS.getCode();
        }
        if (password.equals(user.getPassword())) {
            setSession(user);
            return ResultCode.SUCCESS.getCode();
        } else {
            return ResultCode.ERROR_LOGIN_PASSWORD_ERROR.getCode();
        }
    }

    private void setSession(User user) {
        HttpSession session = BaseUtils.getSession();
        session.setAttribute("userId", user.getId());
        session.setAttribute("username", user.getUsername());
        session.setAttribute("phoneNumber", user.getMobile());
        session.setAttribute("role", user.getRole());
        session.setAttribute("email", user.getEmail());
        String token = UUID.randomUUID().toString();
        session.setAttribute("token", token);
        tokens.put(token, user.getId());
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
        setSession(user);
        return ResultCode.SUCCESS.getCode();
    }

    @Override
    public void logout(String token) {
        tokens.remove(token);
        HttpSession session = BaseUtils.getSession();
        session.invalidate();
    }

    @Override
    public int register(User user) {
        User u = dsl.selectFrom(userT).where(userT.USERNAME.eq(user.getUsername())).fetchOneInto(User.class);
        if (u != null) {
            return ResultCode.ERROR_LOGIN_USERNAME_EXISTS.getCode();
        }
        long id = Long.parseLong(System.currentTimeMillis() + "" + user.getUsername().hashCode());
        user.setId(id);
        user.setRole(Constant.Role.USER);
        userDao.insert(user);
        return ResultCode.SUCCESS.getCode();
    }

    @Override
    public UserInfo getInfo() {
        Long userId = BaseUtils.getUserId();
        User user = dsl.selectFrom(userT).where(userT.ID.eq(userId)).fetchOneInto(User.class);
        if (user == null) {
            throw new CommonException("该账户不存在!");
        }
        Role role = dsl.selectFrom(roleT).where(roleT.ID.eq(user.getRole())).fetchOneInto(Role.class);
        if (role == null) {
            throw new CommonException("该账户存在问题，请联系管理员!");
        }
        String roles = role.getAuth();
        Set<String> set = new HashSet<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user);
        if (roles != null) {
            String[] s = roles.split(",");
            set.addAll(Arrays.asList(s));
        }
        userInfo.setRoles(set);
        return userInfo;
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

    @Override
    public User getProfile() {
        Long userId = BaseUtils.getUserId();
        return userDao.fetchOneById(userId);
    }

    @Override
    public boolean updateUserAvatar(String path) {
        try {
            Long userId = BaseUtils.getUserId();
            dsl.update(userT).set(userT.AVATAR, path).where(userT.ID.eq(userId)).execute();
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    private void sendCaptcha(String phoneNumber) {
        int code = SMSUtils.sendMessage(phoneNumber);
        if (code != -1) {
            CodeMessage codeMessage = new CodeMessage(code, 0, System.currentTimeMillis());
            codeMap.put(phoneNumber, codeMessage);
        }
    }
}
