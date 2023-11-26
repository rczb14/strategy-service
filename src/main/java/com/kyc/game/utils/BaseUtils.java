package com.kyc.game.utils;

import com.kyc.game.dao.tables.pojos.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class BaseUtils {

    private static RedisTemplate redisTemplate;

    public static Long getUserId() {
        if (redisTemplate == null) {
            redisTemplate = (RedisTemplate) SpringBeanUtil.getBean("redisTemplate");
        }
        String token = CookieUtils.getCookie("Admin-Token");
        User user = (User) redisTemplate.opsForValue().get(token);
        return user.getId();
    }

    public static User getUser(String token) {
        if (redisTemplate == null) {
            redisTemplate = (RedisTemplate) SpringBeanUtil.getBean("redisTemplate");
        }
        return (User) redisTemplate.opsForValue().get(token);
    }

    public static String getToken(String userId) {
        if (redisTemplate == null) {
            redisTemplate = (RedisTemplate) SpringBeanUtil.getBean("redisTemplate");
        }
        return redisTemplate.opsForValue().get(userId).toString();
    }

    public static String getValue(String param) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession().getAttribute(param).toString();
    }

    public static HttpSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }
}
