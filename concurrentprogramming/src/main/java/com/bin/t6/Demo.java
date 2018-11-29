package com.bin.t6;

/**
 * 锁重入
 */
public class Demo {

    public synchronized void a() {
        System.out.println("a");
//        b();
    }

    public synchronized void b() {
        System.out.println("b");
    }

    public static void main(String[] args) {

        Demo d1 = new Demo();
        Demo d2 = new Demo();

        new Thread(() -> {
//             Demo d = new Demo();
//             d.a();
            d1.a();
            d2.b();
        }).start();
    }

}
