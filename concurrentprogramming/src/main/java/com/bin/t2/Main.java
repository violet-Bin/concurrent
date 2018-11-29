package com.bin.t2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring实现多线程
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        DemoService ds = context.getBean(DemoService.class);
        ds.a();
        ds.b();
    }
}
