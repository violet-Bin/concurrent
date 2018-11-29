package com.bin.t25;

import java.util.concurrent.Semaphore;

/**
 * 线程间的通信  Semaphore
 *
 */
public class Demo {

    public void method(Semaphore semaphore) {

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "is run ...");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.release();

    }

    public static void main(String[] args) {
        Demo d = new Demo();
        Semaphore semaphore = new Semaphore(10);
        while (true) {
            new Thread(() -> {
                d.method(semaphore);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
