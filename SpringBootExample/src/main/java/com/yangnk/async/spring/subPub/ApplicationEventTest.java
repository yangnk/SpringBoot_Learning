package com.yangnk.async.spring.subPub;

import org.springframework.context.ApplicationEvent;

//自定义事件
public class ApplicationEventTest extends ApplicationEvent {

    public ApplicationEventTest(Object source) {
        super(source);
    }

    /**
     * 事件处理事项
     * @param msg
     */
    public void printMsg(String msg)
    {
        System.out.println("监听到事件：" + ApplicationEventTest.class + ", 时间为：" + msg);
    }
}