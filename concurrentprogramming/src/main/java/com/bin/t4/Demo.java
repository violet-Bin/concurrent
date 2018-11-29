package com.bin.t4;

/**
 * 优先级线程
 */
public class Demo {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Target());
        Thread t2 = new Thread(new Target());

        //值越大，优先级越高
        t1.setPriority(1);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}
