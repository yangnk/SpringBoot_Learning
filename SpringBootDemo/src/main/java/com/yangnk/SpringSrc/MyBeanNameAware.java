package com.yangnk.SpringSrc;

import org.springframework.beans.factory.BeanNameAware;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-29 16:39
 **/
public class MyBeanNameAware implements BeanNameAware{
    @Override
    public void setBeanName(String s) {
//        s = "test";
    }
}
