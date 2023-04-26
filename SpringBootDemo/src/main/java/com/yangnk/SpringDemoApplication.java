package com.yangnk;

//import com.yangnk.test.MyTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringDemoApplication.class);
        app.run(args);
//        String stringStatic = MyTest.getStringStatic();

//        System.out.println(">>>>>>>>>>>>>>>>>>>>stringStatic = " + stringStatic);

    }

}
