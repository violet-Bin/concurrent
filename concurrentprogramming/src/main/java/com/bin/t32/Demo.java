package com.bin.t32;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPool =
                new ThreadPoolExecutor(10, 20, 10, TimeUnit.DAYS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardOldestPolicy());
                        //              线程池的基本大小    线程池的最大大小    线程活动保持时间     线程活动保持时间的单位
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < 100; i++) {

            threadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
            count.getAndIncrement();
        }

        threadPool.shutdown();
        while (Thread.activeCount() > 2);

        System.out.println(count.get());

    }

}
