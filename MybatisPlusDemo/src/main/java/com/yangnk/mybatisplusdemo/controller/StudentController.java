package com.yangnk.mybatisplusdemo.controller;

import com.yangnk.mybatisplusdemo.domain.Student;
import com.yangnk.mybatisplusdemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/testStudent")
    public String testStudent() {
        Student student = studentService.getById(1);
        log.info(">>>>>>>>>>>>", student.toString());
        return student.toString();
    }

}
