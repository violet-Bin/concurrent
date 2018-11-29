package com.bin.t14;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁降级
 */
public class Demo {

    private Map<String, Object> map = new HashMap<>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    private Lock r = rwl.readLock();
    private Lock w = rwl.writeLock();

    private volatile boolean isUpdate;

    public void readWrite() {
        r.lock();
        if (isUpdate) {
            r.unlock();
            w.lock();
            map.put("xx", "xx");
            r.lock();  // 锁降级   读锁降级为写锁，保证线程安全性（有读锁 其他写线程就不能进来） // 还有种是 锁升级
            w.unlock();
        }
        Object obj = map.get("xx");
        System.out.println(obj);
        r.unlock();
    }

    public Object get(String key) {
        r.lock();
        System.out.println(Thread.currentThread().getName() + "读操作正在执行。。。");
        try {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(key);
        } finally {
            r.unlock();
            System.out.println(Thread.currentThread().getName() + "读操作执行完毕。");
        }
    }

    public void put(String key, Object value) {
        w.lock();
        System.out.println(Thread.currentThread().getName() + "写操作正在执行。。。");
        try {
            Thread.sleep(3000);
            map.put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            w.unlock();
            System.out.println(Thread.currentThread().getName() + "写操作执行完毕。");
        }
    }

}
