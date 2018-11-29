package com.bin.t20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyDataSource {

    private LinkedList<Connection> pool = new LinkedList<>();

    private static final int INIT_CONNRCTIONS = 10;

    private static final String DERVER_CLASS = "";
    private static final String USER = "";
    private static final String PASSWORD = "";
    private static final String URL = "";

    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public MyDataSource() {
        for (int i = 0; i < INIT_CONNRCTIONS; i++) {
            try {
                Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                pool.add(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnect() {
        Connection result = null;
        lock.lock();
        try {
            while (pool.size() <= 0) {
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!pool.isEmpty()) {
                result = pool.removeFirst();
            }
            return result;
        } finally {
            lock.unlock();
        }
    }


    public void release(Connection conn) {
        try {
            lock.lock();
            if (conn != null) {
                pool.addLast(conn);
                notifyAll();
            }
        } finally {
            lock.unlock();
        }
    }


}
