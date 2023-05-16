package com.yangnk.test1;

public class ThreadLocalTest {
    static A a = new A();

    static ThreadLocal<A> threadLocal = ThreadLocal.withInitial(() -> a);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int num = i;
            new Thread(() -> {
                threadLocal.get().setNum(num);
                System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get().getNum());
            }, "thread-" + i).start();
        }
    }

    static class A {
        int num = 0;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }
}
