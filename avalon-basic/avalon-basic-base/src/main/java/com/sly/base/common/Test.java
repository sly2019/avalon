package com.sly.base.common;

import java.util.*;

/**
 * @Author by wj on 2021/5/26 16:41
 * @Description TODO
 */
public class Test {

    public static void test1(){
        int size = 10000000;
        double r = Math.random();
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= size; i++){
            map.put(String.valueOf(i), 1);
            list.add(String.valueOf(i));
        }
        if(r > 0.5){
            long t1 = System.currentTimeMillis();
            for(int i = 0; i < 1000; i++){
                int d = (int) Math.random() * size;
                map.remove(d);
            }
            long t2 = System.currentTimeMillis();
            System.out.println("map:" + String.valueOf((int)((t2 - t1))));
        } else {
            long t1 = System.currentTimeMillis();
            for(int i = 0; i < 1000; i++){
                int d = (int) Math.random() * size;
                list.remove(d);
            }
            long t2 = System.currentTimeMillis();
            System.out.println("list " + String.valueOf((int)((t2 - t1))));
        }
    }

    public static void main(String[] args) {

        long t1 = System.currentTimeMillis();
        for(int i = 0; i < 100; i ++){
            test1();
        }
    }
}
