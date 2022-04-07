package com.yangnk.springBootDemo.uploadDemo;

import org.springframework.stereotype.Controller;
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
@Controller
public class UploadController {
    @ResponseBody
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart MultipartFile file) throws IOException {
        System.out.println("======start======");
        String fileName = file.getOriginalFilename();
        String dirPath = Class.class.getClassLoader().getResource("").getPath();
        String distPath = dirPath + fileName;
        System.out.println("=======" + distPath + "======");
        File distFile = new File(distPath);
        Files.copy(file.getInputStream(), distFile.toPath());
        return "upload success.";
    }
}
