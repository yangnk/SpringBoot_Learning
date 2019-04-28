package com.yangnk.emailSender.controller;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-04-25 下午5:10
 **/

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/test")
@Slf4j
public class EmailController {

    @RequestMapping(value = "/emailSender.do", method = RequestMethod.POST)
    public JSONObject add() throws Exception {

        log.info("---------------->>上传测试<<------------------");
        return null;
    }
}
