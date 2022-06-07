package com.yangnk.HFNQueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-04-25 下午5:19
 **/
@SpringBootApplication
public class HFNQueueApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(HFNQueueApplication.class, args);
    }
}