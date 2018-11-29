package com.bin.t5;

/**
 * 饿汉式
 * 线程安全
 */
public class Singleton {

    private Singleton() {}

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }


}
