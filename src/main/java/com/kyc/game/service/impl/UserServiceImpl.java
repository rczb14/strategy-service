package com.kyc.game.service.impl;

import com.kyc.game.common.CommonException;
import com.kyc.game.common.Constant;
import com.kyc.game.common.ResultCode;
import com.kyc.game.dao.tables.daos.UserDao;
import com.kyc.game.dao.tables.pojos.Role;
import com.kyc.game.dao.tables.pojos.User;
import com.kyc.game.service.UserService;
import com.kyc.game.utils.BaseUtils;
import com.kyc.game.utils.SMSUtils;
import com.kyc.game.vo.user.UserInfo;
import jakarta.annotation.Resource;
import org.jooq.DSLContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    DSLContext dsl;

    @Resource
    UserDao userDao;

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    com.kyc.game.dao.tables.User userT = com.kyc.game.dao.tables.User.USER;

    com.kyc.game.dao.tables.Role roleT = com.kyc.game.dao.tables.Role.ROLE;

    SimpleDateFormat sdf = new SimpleDateFormat();

    @Override
    public String login(String username, String password) {
        User user = dsl.selectFrom(userT).where(userT.USERNAME.eq(username)).fetchOneInto(User.class);
        if (user == null) {
            throw new CommonException(ResultCode.ERROR_LOGIN_USERNAME_NOT_EXISTS);
        }
        if (password.equals(user.getPassword())) {
            return setToken(user);
        } else {
            throw new CommonException(ResultCode.ERROR_LOGIN_PASSWORD_ERROR);
        }
    }

    @Override
    public void checkCaptcha(String captchaKey, String code) {
        Object captcha = redisTemplate.opsForValue().get(captchaKey);
        if (captcha == null) {
            throw new CommonException(ResultCode.ERROR_LOGIN_CODE_AFTER_TIME);
        }
        if (!captcha.toString().equals(code)) {
            throw new CommonException(ResultCode.ERROR_LOGIN_CODE);
        }
    }

    private String setToken(User user) {
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(user.getId().toString(), token, 1, TimeUnit.DAYS);
        redisTemplate.opsForValue().set(token, user, 1, TimeUnit.DAYS);
        return token;
    }

    @Override
    public String login(String phoneNumber) {
        User user = dsl.selectFrom(userT).where(userT.MOBILE.eq(phoneNumber)).fetchOneInto(User.class);
        if (user == null) {
            throw new CommonException(ResultCode.ERROR_LOGIN_USERNAME_NOT_EXISTS);
        }
        return setToken(user);
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(token);
    }

    @Override
    public void register(User user) {
        User u = dsl.selectFrom(userT).where(userT.USERNAME.eq(user.getUsername())).fetchOneInto(User.class);
        if (u != null) {
            throw new CommonException(ResultCode.ERROR_LOGIN_USERNAME_EXISTS);
        }
        long id = Long.parseLong(System.currentTimeMillis() + "" + user.getUsername().hashCode());
        user.setId(id);
        user.setRole(Constant.Role.USER);
        userDao.insert(user);
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
        Object code = redisTemplate.opsForValue().get(phoneNumber);
        if (code == null) {
            sendCaptcha(phoneNumber);
        }
    }

    @Override
    public User getProfile() {
        Long userId = BaseUtils.getUserId();
        return userDao.fetchOneById(userId);
    }

    @Override
    public void updateProfile(User user) {
        dsl.update(userT).set(userT.USERNAME, user.getUsername())
                .set(userT.MOBILE, user.getMobile())
                .set(userT.EMAIL, user.getEmail())
                .set(userT.GENDER, user.getGender()).execute();
    }

    @Override
    public void updatePwd(String oldPassword, String newPassword) {
        Long userId = BaseUtils.getUserId();
        User user = userDao.fetchOneById(userId);
        String password = user.getPassword();
        if (!oldPassword.equals(password)) {
            throw new CommonException("修改密码失败，旧密码输入错误！");
        }
        if (newPassword.equals(password)) {
            throw new CommonException("修改密码失败，新密码不能与旧密码相同！");
        }
        dsl.update(userT).set(userT.PASSWORD, newPassword).where(userT.ID.eq(userId)).execute();
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
            redisTemplate.opsForValue().set(phoneNumber, String.valueOf(code), 60, TimeUnit.SECONDS);
        }
    }
}
