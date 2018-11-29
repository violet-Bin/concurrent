package com.bin.t1;

public class NewThread implements Runnable {

    @Override
    public synchronized void run() {
        while (true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("自定义的 Thread is starting...");
        }
    }

    public static void main(String[] args) {
        NewThread n = new NewThread();
        Thread thread1 = new Thread(n);
        thread1.start();
        while (true) {
            synchronized (n) {
                System.out.println("主线程ing...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n.notifyAll();
            }
        }

    }



}
