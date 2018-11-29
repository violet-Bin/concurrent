package com.bin.t15;

/**
 * 线程之间的通信 wait() , notify()
 */
public class Demo {

    private volatile int signal;

    private void setSignal(int value) {
        this.signal = value;
    }

    private int get() {
        return signal;
    }

    public static void main(String[] args) {
        Demo d = new Demo();

        new Thread(() -> {
            synchronized (d) {
                System.out.println("修改状态的线程执行。。。");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                d.setSignal(1);
                System.out.println("状态值修改成功");
                d.notify();
            }
        }).start();

        new Thread(() -> {
            synchronized (d) {
                // 等待signal为1开始执行，否则不执行
                while (d.get() != 1) {
                    try {
                        d.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 当为1的时候，执行代码
                System.out.println("模拟代码执行。。。");
            }
        }).start();

    }


}
