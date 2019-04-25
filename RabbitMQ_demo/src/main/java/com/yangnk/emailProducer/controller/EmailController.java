package com.yangnk.emailProducer.controller;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-04-25 下午5:10
 **/

import com.alibaba.fastjson.JSONObject;
import com.yangnk.emailProducer.service.EmailService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController()
@RequestMapping(value = "/emails")
public class EmailController {

    @Resource
    private EmailService emailService;
    /**
     * 新增方法
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
}
