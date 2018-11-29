package com.bin.t33;

import java.util.concurrent.*;

/**
 * 线程池
 */
public class Demo {

    public static void main(String[] args) {

        //10个线程来处理大量任务
//        ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 10, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
//        ExecutorService pool = Executors.newFixedThreadPool(10);  // 固定数量
//        ExecutorService pool = Executors.newCachedThreadPool();  // 可变
//        ExecutorService pool = Executors.newSingleThreadExecutor(); // 单个线程
//        ScheduledExecutorService pool = Executors.newScheduledThreadPool(10); // 计划任务

        ExecutorService pool = Executors.newWorkStealingPool();


        while (true) {

//            pool.schedule(()-> System.out.println(Thread.currentThread().getName()),5, TimeUnit.SECONDS);

//            pool.execute(() -> {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
        }


    }


}
