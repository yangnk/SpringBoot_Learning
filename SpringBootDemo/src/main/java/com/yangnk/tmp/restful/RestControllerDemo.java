package com.yangnk.restful;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestControllerDemo {

    /**
     * 普通Get
     *
     * @param name
     * @return
     */
    @GetMapping("/get")
    private String getMethod(@RequestParam("name") String name) {
        System.out.println("getMethod : name=" + name);
        return name;
    }

    /**
     * Restful Get
     *
     * @param name
     * @return
     */
    @GetMapping("/getName/{name}")
    private String getRestName(@PathVariable("name") String name) {
        System.out.println("getRestName : name=" + name);
        return name;
    }

    /**
     * post
     *
     * @param name
     * @return
     */
    @PostMapping("/post")
    private String postMethod(@RequestParam("name") String name) {
        System.out.println("postMethod : name=" + name);
        return name;
    }

    /**
     * post json
     *
     * @param stu
     * @return
     */
    @PostMapping("/postBody")
    public String postBodyMethod(@RequestBody String stu) {
        Student student = JSONObject.parseObject(stu, Student.class);
        System.out.println("postBodyMethod : student=" + student);
        return student.toString();
    }

    /**
     * delete
     *
     * @param name
     * @return
     */
    @DeleteMapping("/delete")
    public String deleteMethod(@RequestParam("name") String name) {
        System.out.println("deleteMethod : name=" + name);
        return name;
    }

    /**
     * put
     *
     * @param name
     * @return
     */
    @PutMapping("/put")
    public String putMethod(@RequestParam("name") String name) {
        System.out.println("putMethod : name=" + name);
        return name;
    }
}
