package com.bin.t7;

public class Demo2 {

    public volatile boolean run = false;

    public static void main(String[] args) {

        Demo2 d = new Demo2();

        new Thread(() -> {
            for(int i = 1;i<=10;i++) {
                System.err.println("Ö´ÐÐÁËµÚ " + i + " ´Î");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            d.run = true;
        }).start();

        new Thread(() -> {
            while(!d.run) {
                // ²»Ö´ÐÐ
            }
            System.out.println("Ïß³Ì2Ö´ÐÐÁË...");
        }).start();


    }


}
