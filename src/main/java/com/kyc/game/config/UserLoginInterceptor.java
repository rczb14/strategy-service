package com.kyc.game.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean bool = true;
        HttpSession session = request.getSession();
        String tokenI = session.getAttribute("token").toString();
        if (StringUtils.isEmpty(tokenI)) {
            bool = false;
        }
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            bool = false;
        }
        // token验证
        if (!tokenI.equals(token)) {
            bool = false;
        }
        if (!bool) {
            PrintWriter writer = null;
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=utf-8");
            /*try {
                writer = response.getWriter();
                writer.print(new JSONObject(ResultData.loginError()));

            } catch (IOException e) {
                log.error("response error", e);
            } finally {
                if (writer != null)
                    writer.close();
            }*/
        }
        return bool;
    }
}
