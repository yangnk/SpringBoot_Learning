package com.yangnk.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogMapper blogMapper;

    @GetMapping(value="/query")
    public List<Blog> query()
    {
        return blogMapper.query();
    }
}

