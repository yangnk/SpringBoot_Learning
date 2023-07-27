//package com.yangnk.redisDemo.controller;
//
//import com.yangnk.redisDemo.entity.User;
//import com.yangnk.redisDemo.service.impl.RedisService;
//import com.yangnk.redisDemo.service.UserService;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * ${DESCRIPTION}
// *
// * @author yangningkai
// * @create 2022-05-13 20:37
// **/
//@RestController
//public class UserController {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    RedisService redisService;
//
//    @GetMapping("/test10")
//    public String test10() {
//        String s = userService.selectByPrimaryKey(1);
//        return s;
//    }
//
//    @GetMapping("/getValue")
//    public String getValue(@Param("name") String name) {
//        User user = userService.selectByName(name);
//        return user.toString();
//    }
//
//    @PostMapping("/addValue")
//    public String addValue(@Param("name") String name) {
//        userService.add(new User(100, name));
//        return "succss";
//    }
//}
