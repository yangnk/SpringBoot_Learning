package com.yangnk.SpringSrc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-04-29 16:12
 **/
public class AnnotationApplicationContextTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(ctx.getBean("helloFactoryBean"));
        System.out.println(ctx.getBean("&helloFactoryBean"));


//        System.out.println("-----------------------------------------------------------");
//        Entitlement ent = (Entitlement) ctx.getBean("entitlement");
//
//        System.out.println(ent.getName());
//        System.out.println(ent.getTime());
//
//        System.out.println("-----------------------------------------------------------");
//
//        AppConfig appConfig = ctx.getBean(AppConfig.class);
//        Entitlement entitlement = appConfig.entitlement();
//        System.out.println(entitlement.getName());
//        System.out.println(entitlement.getTime());

    }

}
