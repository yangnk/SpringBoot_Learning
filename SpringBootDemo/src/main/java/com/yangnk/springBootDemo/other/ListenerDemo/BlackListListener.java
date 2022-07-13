package com.yangnk.springBootDemo.ListenerDemo;

import org.springframework.context.ApplicationListener;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 17:33
 **/
public class BlackListListener implements ApplicationListener<BlackListEvent> {
    @Override
    public void onApplicationEvent(BlackListEvent event) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "收到了黑名单事件：" + event.getAddr());
    }
}
