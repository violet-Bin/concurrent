package com.bin.t24;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 线程间的通信  CyclicBarrier
 * 10个人开会，等人到齐了再开始
 */
public class Demo {

    Random random = new Random();

    public void meeting(CyclicBarrier barrier) {
        try {
            Thread.sleep(random.nextInt(4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "到达会议室。。。");

//        if (Thread.currentThread().getName().equals("Thread-1")) {
//            throw new RuntimeException();
//        }

         try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "发言。。");
    }

    public static void main(String[] args) {

        Demo demo = new Demo();

        CyclicBarrier barrier = new CyclicBarrier(10, () -> System.out.println("开始开会。。。"));

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                demo.meeting(barrier);
            }).start();
        }


    }


}
