package com.yangnk.jpademo.controller;

import com.yangnk.jpademo.entity.User;
import com.yangnk.jpademo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 16:10
 **/
@RestController
@Slf4j
 public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/user")
    public String hello1() throws Exception {

        List<User> user = userService.getUser();
        return user.toString();
    }
}

