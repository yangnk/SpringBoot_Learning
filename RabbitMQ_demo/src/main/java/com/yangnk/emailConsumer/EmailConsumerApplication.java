package com.yangnk.emailConsumer;

import com.yangnk.emailProducer.EmailProducerApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-04-25 下午6:39
 **/
@RestController
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.yangnk.emailConsumer"})
@SpringBootApplication
public class EmailConsumerApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(EmailConsumerApplication.class, args);
    }
}
