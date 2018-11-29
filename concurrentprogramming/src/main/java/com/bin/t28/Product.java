package com.bin.t28;

/**
 * Future设计模式实现  实现类似于JDK提供的Future
 */
public class Product {

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Product(int id, String name) {
        try {
            System.out.println("开始生产 " + name);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.id = id;
        this.name = name;
        System.out.println(name + " 生产完毕。");
    }
}
