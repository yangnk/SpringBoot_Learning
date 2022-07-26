package com.yangnk.test;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        StackTraceElement[] stackTrace1 = new RuntimeException().getStackTrace();
        for (StackTraceElement item : stackTrace1) {
            if ("main".equals(item.getMethodName())) {
                Test obj = (Test)Class.forName(item.getClassName()).newInstance();
                obj.print();
            }
        }
    }

    public final static void print() {
        System.out.println(System.currentTimeMillis());
    }
}
