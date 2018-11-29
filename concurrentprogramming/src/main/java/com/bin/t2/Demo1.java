package com.bin.t2;

public class Demo1 extends Thread {

    public Demo1(String name) {
        super(name);

    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println(getName() + "Thread is starting..");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Demo1 d1 = new Demo1("first-thread");
        Demo1 d2 = new Demo1("second-thread");

//        d1.setDaemon(true);//设置为守护线程
//        d2.setDaemon(true);

        d1.start();
        d2.start();

        d1.interrupt();
    }
}
