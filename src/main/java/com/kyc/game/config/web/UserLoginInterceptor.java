package com.kyc.game.config.web;

import com.alibaba.fastjson2.JSONObject;
import com.kyc.game.dao.tables.pojos.User;
import com.kyc.game.utils.BaseUtils;
import com.kyc.game.utils.CookieUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        boolean bool = true;
        System.out.println("================请求地址:" + request.getRequestURI());

        String token = CookieUtils.getCookie("Admin-Token");
        String msg = "";
        if ("none".equals(token)) {
            bool = false;
            msg = "登录过期，请重新登录！";
        } else {
            User user = BaseUtils.getUser(token);
            String tokenL = BaseUtils.getToken(String.valueOf(user.getId()));
            if (!token.equals(tokenL)) {
                bool = false;
                msg = "您的账号已在其他地方登录！";
            }
        }

        if (!bool) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            try (PrintWriter writer = response.getWriter()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", 401);
                jsonObject.put("message", msg);
                writer.print(JSONObject.toJSONString(jsonObject));
            } catch (IOException e) {
                log.error("response error", e);
            }
        }
        return bool;
    }
}
