package com.yangnk.logindemo.controller;

import com.yangnk.logindemo.entity.User;
import com.yangnk.logindemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-08 16:12
 **/
@Controller
@ResponseBody
@RequestMapping("/login")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUserInfo(@RequestParam(value = "username") String userName) {
        User user = userService.getUser(userName);
        logger.info("===login user is:{}===",user.toString());
        return user.toString();
    }
}
