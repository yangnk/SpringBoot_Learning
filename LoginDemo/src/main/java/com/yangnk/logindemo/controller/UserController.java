package com.yangnk.logindemo.controller;

import com.yangnk.logindemo.entity.User;
import com.yangnk.logindemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
@Api(value = "用户管理", description = "用户管理API", position = 100, protocols = "http")
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ApiOperation("/根据学生id获取学生信息")
    @ApiImplicitParam(name = "username",value = "用户名",required = true,paramType = "query",dataType = "String")
    public String getUserInfo(@RequestParam(value = "username") String userName) {
        User user = userService.getUser(userName);
        logger.info("===login user is:{}===",user.toString());
        return user.toString();
    }

    @RequestMapping(value = "/smscode", method = RequestMethod.POST)
    public void sendSmsCode(@RequestHeader(value = "username") String userName,
                              @RequestHeader(value = "telephone") String telephone) {
        userService.sendSmsCode(userName, telephone);
        logger.info("===success send smsCode.===");
    }


    @RequestMapping(value = "/smscode", method = RequestMethod.GET)
    public boolean getSmsCode(@RequestHeader(value = "username") String userName,
                           @RequestHeader(value = "userSmsCode") String userSmsCode) {
        String smsCode = userService.getSmsCode(userName);

        if ((!StringUtils.isEmpty(smsCode)) && smsCode.equals(userSmsCode)) {
            logger.info("===input smsCode is equal to telephone smsCode.===");
            return true;
        } else {
            logger.info("===input smsCode is not equal to telephone smsCode.===");
            return false;
        }
    }
}
