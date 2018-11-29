package com.bin.t2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 带返回值的线程
 */
public class Demo4 implements Callable<Integer> {

    public static void main(String[] args) throws Exception {

        Demo4 d = new Demo4();
        FutureTask<Integer> task = new FutureTask<>(d);
        Thread t = new Thread(task);
        t.start();
        System.out.println("othes...");
        Integer res = task.get();
        System.out.println("res : " + res);


    }

    @Override
    public Integer call() throws Exception {  //相当于run()
        System.out.println("计算中。。。");
        Thread.sleep(3000);
        return 1;
    }
}
