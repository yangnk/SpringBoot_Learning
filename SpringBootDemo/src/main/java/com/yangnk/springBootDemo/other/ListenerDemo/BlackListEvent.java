package com.yangnk.springBootDemo.ListenerDemo;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-04 17:32
 **/
public class BlackListEvent extends ApplicationEvent {
    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String addr;
    public BlackListEvent(Object source,String addr) {
        super(source);
        this.addr = addr;
    }

    public BlackListEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
