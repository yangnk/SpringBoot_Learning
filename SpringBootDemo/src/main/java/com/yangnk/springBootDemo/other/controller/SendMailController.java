package com.yangnk.springBootDemo.controller;

import com.yangnk.springBootDemo.service.SendMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-01-25 20:48
 **/

@Controller
public class SendMailController {
    @Autowired
    SendMail sendMail;

    @RequestMapping(value = "/sendMail",method = RequestMethod.GET)
    public String sendMail(){
        System.out.println("sendMail start");
        sendMail.sendMail();
        System.out.println("sendMail end");
        return "index";
    }
}
