package com.ssafy.happyhouse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.happyhouse.common.LoginInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
        .addPathPatterns(
        		"/map/**",
        		"/interestslist/**",
        		"/user/**",
        		"/apt/**",
        		"/friends/**"); // 모든 경로에 interceptor 설정
//        .excludePathPatterns(
//        		"/", 
//        		"/index.html",
//        		"favicon.ico",
//        		"/css/**",
//        		"/js/**",
//        		"/login/**",
//        		"/codes/**",
//        		"/register/**"
//        		); // interceptor 제외할 경로 설정
    }
}
