package com.yangnk.test1;

import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5);


        scheduledThreadPoolExecutor.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
//                DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);
//                Date date = new Date();
//                String format = dateFormat.format(date);
//                System.out.println("currenntTime is : " + format);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH-mm-ss.SSS");
                Date date = new Date();
                String format = simpleDateFormat.format(date);
                System.out.println("currenntTime is : " + format);

            }
        }, 0, 3, TimeUnit.SECONDS);
    }
}
