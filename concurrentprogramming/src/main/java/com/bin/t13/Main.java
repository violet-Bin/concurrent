package com.bin.t13;

public class Main {

    public static void main(String[] args) {
        Demo d = new Demo();

        new Thread(() -> d.put("a", 1)).start();
        new Thread(() -> d.put("b", 2)).start();
        new Thread(() -> d.put("c", 3)).start();
        new Thread(() -> d.get("a")).start();
        new Thread(() -> d.get("b")).start();
    }
}
