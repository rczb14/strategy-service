package com.kyc.game.config.web;

import com.alibaba.fastjson2.JSONObject;
import com.kyc.game.utils.BaseUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        boolean bool = true;
        System.out.println(request.getRequestURI());

        HttpSession session = request.getSession();
        Object userId = BaseUtils.getUserId();
        if (userId == null) {

            String tokenI = (String) session.getAttribute("token");
            String token = request.getParameter("token");

            if (StringUtils.isEmpty(tokenI)) {
                bool = false;
            } else if (StringUtils.isEmpty(token)) {
                bool = false;
            } else if (!tokenI.equals(token)) {
                bool = false;
            }
        }
        if (!bool) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            try (PrintWriter writer = response.getWriter()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", 401);
                writer.print(JSONObject.toJSONString(jsonObject));
            } catch (IOException e) {
                log.error("response error", e);
            }
        }
        return bool;
    }
}
