package com.bin.t23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 线程间的通信  CountDownLatch
 * 多个线程同时计算几行代码，都计算完后，再求和
 *
 */
public class Demo2 {

    private int[] nums;

    public Demo2(int line) {
        nums = new int[line];
    }

    public void calc(String line, int index, CountDownLatch latch) {
        String[] nus = line.split(",");
        int total = 0;
        for (String num : nus) {
            total += Integer.parseInt(num);
        }
        nums[index] = total;
        System.out.println(Thread.currentThread().getName() + "执行计算任务。。。" + line + "结果为：" + total);
        latch.countDown();
    }

    public void sum() {
        System.out.println("汇总线程开始执行任务。。");
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        System.out.println("最终结果为： " + total);
    }


    public static void main(String[] args) {

        List<String> contents = readFile();
        int lineCount = contents.size();

        CountDownLatch latch = new CountDownLatch(lineCount);

        Demo2 d = new Demo2(lineCount);

        for (int i = 0; i < lineCount; i++) {
            final int j = i;
            new Thread(() -> d.calc(contents.get(j), j, latch)).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        d.sum();
    }

    private static List<String> readFile() {

        List<String> contents = new ArrayList<>();
        String line = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("/Users/jiangjiabin/desktop/num"));
            while ((line = br.readLine()) != null) {
                contents.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return contents;

    }


}
