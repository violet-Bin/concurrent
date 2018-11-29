package com.bin.t15;

public class Target2 implements Runnable {

    private Demo3 demo;

    public Target2(Demo3 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.get();
    }
}
