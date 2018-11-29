package com.bin.t10;

public class Squence {

    private MyLock lock = new MyLock();

    private int value;

    public int getNext() {
        lock.lock();
        int a = value++;
        lock.unlock();
        return a;
    }


    public static void main(String[] args) {

        Squence s = new Squence();

        new Thread(() -> {
            while (true)
            System.out.println(s.getNext());
        }).start();

        new Thread(() -> {
            while (true)
            System.out.println(s.getNext());
        }).start();

        new Thread(() -> {
            while (true)
            System.out.println(s.getNext());
        }).start();

        new Thread(() -> {
            while (true)
            System.out.println(s.getNext());
        }).start();

    }


}
