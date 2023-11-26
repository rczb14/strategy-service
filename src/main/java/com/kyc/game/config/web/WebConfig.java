package com.kyc.game.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/login/login",
                        "/login/logout/**",
                        "/login/captchaImage",
                        "/login/register",
                        "/public/**"
                        );

    }

    @Bean
    public UserLoginInterceptor loginInterceptor() {
        return new UserLoginInterceptor();
    }
}
