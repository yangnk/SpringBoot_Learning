package com.yangnk.mysqldemo.controller;


//import com.yangnk.dynamicThreadPool.MyServce;
import com.yangnk.mysqldemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    public String user(){
        userService.getUserMapper();
        return new Date().toString();
    }

}

