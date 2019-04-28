package com.yangnk.emailSender.myTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-04-27 上午8:33
 **/

@Controller
@RequestMapping("/test")
public class myTest {

    @GetMapping("/upload.page")
    public ModelAndView upload(){
        return new ModelAndView("/upload");
    }
}
