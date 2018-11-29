package com.bin.t2;

import java.util.Arrays;
import java.util.List;

/**
 * Lambda表达式实现多线程
 */
public class Demo7 {

    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(10,20,30,40);
        int res = new Demo7().add(values);
        System.out.println("  " + res);
    }

    public int add (List<Integer> values) {
//		values.parallelStream().forEach(System.out :: println);
        return values.parallelStream().mapToInt( i -> i * 2).sum();
    }


}
