package com.bin.t15;

import java.util.concurrent.TimeUnit;

public class Demo3 {

    private volatile int signal;

    public synchronized void setSignal() {
        this.signal = 1;
        notifyAll();  // notify() 会随机叫醒一个处于wait状态的线程
                        // notifyAll() 叫醒所有处于wait状态的线程 ，争夺时间片线程只有一个
        System.out.println("叫醒之后休眠开始。。");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int get() {
        System.out.println(Thread.currentThread().getName() + "执行了。。。");
        if (signal != 1) {
            try {
                wait();  // 调用wait()  会释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "执行 over。。。");
        return signal;
    }

    public static void main(String[] args) {

        Demo3 d = new Demo3();
        Target1 t1 = new Target1(d);
        Target2 t2 = new Target2(d);

        new Thread(t2).start();
        new Thread(t2).start();
        new Thread(t2).start();
        new Thread(t2).start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(t1).start();

    }

}
