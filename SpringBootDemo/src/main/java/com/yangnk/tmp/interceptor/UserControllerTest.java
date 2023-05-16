package com.yangnk.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserControllerTest {

    @RequestMapping("/login")
    public String login() {
        return "user_login";
    }

    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest request, String name) {

        request.getSession().setAttribute("name", name);
        return "redirect:/user/login";
    }

}
