package com.bin.t5;

/**
 * 懒汉式
 */
public class Singleton2 {

   private Singleton2() {}

   private static volatile Singleton2 instance = null;

    /**
     * 双重检查加锁
     * @return
     */
   public static Singleton2 getInstance() {
       if (instance == null) {  // 非原子性操作，存在线程安全性问题
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           synchronized (Singleton2.class) {
               if (instance == null) {
                   instance = new Singleton2();
                   // 指令重排序

                   // 1 申请内存
                   // 2 在这块空间里实例化对象
                   // 3 instance的饮用指向这块空间地址     加 volatile

               }
           }
       }
           return instance;
   }



}
