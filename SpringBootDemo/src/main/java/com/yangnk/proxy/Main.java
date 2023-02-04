package com.yangnk.proxy;

public class Main {
    public static void main(String[] args) {
        System.out.println("===jkdproxy start===");
        JDKProxy jdkProxy = new JDKProxy();
        Manager manager = (Manager) jdkProxy.newProxy(new ManagerImpl());
        manager.addUser("id_1","pwd_1");
        System.out.println("===jkdproxy end===");


        System.out.println("===cglibproxy start===");
        CgLibProxy cgLibProxy = new CgLibProxy();
        ManagerImpl manager1 = (ManagerImpl) cgLibProxy.newObject(new ManagerImpl());
        manager1.addUser("id_2","pwd_2");
        System.out.println("===cglibproxy end===");

    }
}
