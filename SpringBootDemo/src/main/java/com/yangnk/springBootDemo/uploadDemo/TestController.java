package com.yangnk.springBootDemo.uploadDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-01 19:59
 **/
@RestController
public class TestController {

    @RequestMapping("/helloa")
    public String sayHello(String string){
        System.out.println("helloa");
        System.out.println(string);
        return "helloa";
    }

    @RequestMapping(value = "/home")
    public String home(Model model) {
        return "upload";
    }
}
