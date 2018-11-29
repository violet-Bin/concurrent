package com.bin.t28;

public class Demo {

    public static void main(String[] args) {

        ProductFactory pf = new ProductFactory();

        // 下单 交钱
        Future f = pf.createProduct("蛋糕");

        System.out.println("去上班了，下班来取。。。");
        // 拿着订单获取产品
        System.out.println("我拿着蛋糕回家" + f.getProduct());

    }


}
