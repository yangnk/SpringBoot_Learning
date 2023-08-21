package com.yangnk.dynamicThreadPool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class MyController {

    @Autowired
    MyService myService;

    @RequestMapping(value = "startExeperiment", method = RequestMethod.GET)
    String startExeperiment(@RequestParam int size) {
        myService.startExeperiment(size);
        return new Date().toString();
    }

    @RequestMapping(value = "changeSize", method = RequestMethod.GET)
    String changeSize(@RequestParam int size) {
        myService.changeSize(size);
        return new Date().toString();
    }

    @RequestMapping(value = "noVmExeperiment", method = RequestMethod.GET)
    String noVmExeperiment(@RequestParam int size) {
        myService.noVmExeperiment(size);
        return new Date().toString();
    }

}
