package com.yangnk.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Object object;

    public Object newProxy(Object targetObject) {
        this.object = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("===before JDKProxy invoke===");
        Object obj = method.invoke(object, args);
        System.out.println("===after JDKProxy invoke===");
        return obj;
    }
}
