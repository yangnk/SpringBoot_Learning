package com.yangnk.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String name = (String)request.getSession().getAttribute("name");
        if (name != null) {
            System.out.println("正常登录");
            return true;

        } else {
            System.out.println("登录异常");
            response.sendRedirect("/login/toLogin");
            return false;
        }
    }
}
