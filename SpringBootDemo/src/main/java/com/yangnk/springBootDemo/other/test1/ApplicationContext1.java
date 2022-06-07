package com.yangnk.springBootDemo.test1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2022-03-03 20:42
 **/
public class ApplicationContext1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        Entitlement ent = (Entitlement)ctx.getBean("entitlement");
        System.out.println(ent.getName());
        System.out.println(ent.getTime());
        Entitlement ent2 = (Entitlement)ctx.getBean("entitlement2");
        System.out.println(ent2.getName());
        System.out.println(ent2.getTime());
        ctx.close();
    }
}
