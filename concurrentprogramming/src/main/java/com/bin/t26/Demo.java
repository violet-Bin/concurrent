package com.bin.t26;

import java.util.concurrent.Exchanger;

/**
 * Exchanger
 */
public class Demo {

    public void a(Exchanger<String> exch) {
        System.out.println("a() 执行。。。");
        try {
            System.out.println("a方法开始抓取数据。。。");
            Thread.sleep(2000);
            System.out.println("a方法抓取数据结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String res = "12345";
        try {
            System.out.println("a等待对比结果。。。");
            exch.exchange(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void b(Exchanger<String> exch) {
        System.out.println("b() 开始执行。。。");
        try {
            System.out.println("b方法开始抓取数据。。。");
            Thread.sleep(4000);
            System.out.println("b方法抓取数据结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String res = "12345";
        String value = null;
        try {
            value = exch.exchange(res);
            System.out.println("开始进行比对。。。");
            System.out.println("比对结果为：" + value.equals(res));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        Exchanger<String> exch = new Exchanger<>();
        new Thread(() -> demo.a(exch)).start();
        new Thread(() -> demo.b(exch)).start();
    }


}
