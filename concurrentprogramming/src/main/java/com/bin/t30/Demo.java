package com.bin.t30;

import java.util.*;

/**
 * 并发容器和同步容器
 */
public class Demo {

    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();
        Collections.synchronizedList(list);

        Map<String, Object> map = new HashMap();
        Collections.synchronizedMap(map);

    }

}
