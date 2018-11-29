package com.bin.t10;

public class Demo {

    MyLock lock = new MyLock();

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
        Demo d = new Demo();

        new Thread(() -> d.a()).start();


    }




}
