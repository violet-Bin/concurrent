package com.bin.t15;

public class Target1 implements Runnable {

    private Demo3 demo;

    public Target1(Demo3 demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.setSignal();
    }
}
