package com.yangnk.emailMQ.controller;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-04-25 下午5:10
 **/

import com.alibaba.fastjson.JSONObject;
import com.yangnk.emailMQ.service.EmailService;
import com.yangnk.emailMQ.service.impl.SmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController()
@RequestMapping(value = "/emails")
public class RabbitMQController {

    @Resource
    private EmailService emailService;

    @Autowired
    private SmsServiceImpl smsService;

    /**
     * 测试接口
     *
     * @param jsonObject
     * @return
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.POST)
    public JSONObject add(@RequestBody JSONObject jsonObject) throws Exception {
        /* json结构体
        {
            "to":"xxx@163.com",
            "subject":"xxx",
            "text":"<html><head></head><body><h1>邮件测试</h1><p>hello!this is mail test。</p></body></html>"
        }
         */
        emailService.sendEmail(jsonObject.toJSONString());
        return jsonObject;
    }

    /**
     * 测试接口
     *
     * @param
     * @return
     * @throws Exception
     */
    @GetMapping("/sms")
    public void addSms(@RequestParam("sms") String sms) throws Exception {
        smsService.sendSms(sms);
    }
}
