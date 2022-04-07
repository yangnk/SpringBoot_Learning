package com.yangnk.springBootDemo.ListenerDemo;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 17:45
 **/
@Component
public class AnnotationBlackListListener {

    @EventListener
    public void broadcastEven(BlackListEvent event) {
        String threaid = Thread.currentThread().getName();
        System.out.println("annotation listener------------------" + threaid);
    }

}
