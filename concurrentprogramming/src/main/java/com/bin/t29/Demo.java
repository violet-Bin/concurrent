package com.bin.t29;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join 框架
 */
public class Demo extends RecursiveTask<Integer> {


    private int begin;
    private int end;

    public Demo(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        System.out.println(Thread.currentThread().getName()+"...");
        int sum = 0;
        //拆分任务
        if (end - begin <= 2) {
            // 计算
            for (int i = begin; i <= end; i++) {
                sum += i;
            }
        } else {
            // 拆分
            Demo d1 = new Demo(begin, (begin + end) / 2);
            Demo d2 = new Demo((begin + end) / 2 + 1, end);

            // 执行任务
            d1.fork();
            d2.fork();

            Integer a = d1.join();
            Integer b = d2.join();
            sum = a + b;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {

        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Integer> future = pool.submit(new Demo(1, 100000));

        System.out.println("。。。");

        System.out.println("计算的值为：" + future.get());

    }


}
