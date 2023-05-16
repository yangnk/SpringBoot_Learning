package com.yangnk.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibProxy implements MethodInterceptor {
    private Object object;

    public Object newObject(Object targetObject) {
        this.object = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(object.getClass());
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("===before CgLibProxy invoke===");
        Object obj = method.invoke(object, objects);
        System.out.println("===after CgLibProxy invoke===");
        return obj;
    }
}
