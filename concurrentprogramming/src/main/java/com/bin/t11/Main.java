package com.bin.t11;

public class Main {

    private int value;
    private MyLock2 lock = new MyLock2();

    public int getNext() {
        lock.lock();
        try {
            Thread.sleep(300);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }

    }

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {

        Main m = new Main();

        new Thread(() ->m.a()).start();

//             new Thread(() -> {
//            while (true) {
//                System.out.println(Thread.currentThread().getName() + " " + m.getNext());
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (true) {
//                System.out.println(Thread.currentThread().getName() + " " + m.getNext());
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (true) {
//                System.out.println(Thread.currentThread().getName() + " " + m.getNext());
//            }
//        }).start();
//
//        new Thread(() -> {
//            while (true) {
//                System.out.println(Thread.currentThread().getName() + " " + m.getNext());
//            }
//        }).start();

    }

}
