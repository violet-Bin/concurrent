package com.bin.t2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器
 */
public class Demo5 {

    public static void main(String[] args) {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("timertask is run");
            }
        }, 0, 1000);
    }

}
