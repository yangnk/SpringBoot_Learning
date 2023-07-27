package com.yangnk.HappyCaptcha;

import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/happy-captcha")
public class HappyCaptchaController {
    @GetMapping("/generator")
//    @TokenCheck(required = false)
    public void generatorCode(HttpServletRequest request, HttpServletResponse response){
        HappyCaptcha.require(request, response)
                .style(CaptchaStyle.ANIM)//设置动画
                .type(CaptchaType.ARITHMETIC_ZH)//设置算数验证码
                .build().finish();
    }
    @GetMapping("/verify")
//    @TokenCheck(required = false)
    public String verify(@RequestParam String verifyCode, HttpServletRequest request){
        Boolean aBoolean=HappyCaptcha.verification(request, verifyCode,true);
        if(aBoolean){
            HappyCaptcha.remove(request);
            return "通过";
        }
        return "不通过";
    }
}
