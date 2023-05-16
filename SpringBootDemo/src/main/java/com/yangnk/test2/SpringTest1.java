package com.yangnk.test2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SpringTest1 {
    public static void main(String[] args) {
        BeanFactory bf = new XmlBeanFactory( new ClassPathResource("spring-config.xml"));
//        MyTestBean myTestBean = (MyTestBean) bf.getBean("myTestBean");
//        System.out.println(myTestBean.getName());

        Car car = (Car) bf.getBean("car");
        System.out.println("car.toString() = " + car.toString());
    }
}
