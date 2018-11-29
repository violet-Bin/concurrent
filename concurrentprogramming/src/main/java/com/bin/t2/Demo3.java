package com.bin.t2;

/**
 * 匿名内部类
 */
public class Demo3 {

    public static void main(String[] args) {

//        new Thread() {
//            @Override
//            public void run() {
//                System.out.println("start...");
//            }
//        }.start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("thread start ..");
//            }
//        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        }) {
            public void run() {
                System.out.println("sub");
            };
        }.start();




    }

}
