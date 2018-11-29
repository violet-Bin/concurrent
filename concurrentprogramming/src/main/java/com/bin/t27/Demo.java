package com.bin.t27;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 提前完成任务之 Future 使用
 */
public class Demo {

    /*
     * Callable 和 Runnable 的区别
     *
     * Runnable run方法是被线程调用的，在run方法是异步执行的
     *
     * Callable 的call方法，不是异步执行的，是由Future的run方法调用的
     *
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> callable = () -> {
            System.out.println("正在计算结果。。。");
            Thread.sleep(3000);
            return 1;
        };

        FutureTask<Integer> task = new FutureTask<>(callable);

        Thread thread = new Thread(task);
        thread.start();

        // do sth
        System.out.println("干点别的。。");

        Integer result = task.get();
        System.out.println(result);


    }

}
