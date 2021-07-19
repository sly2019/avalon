package com.sly.base.common.test;

/**
 * @Created by wj on 2021/6/23
 * @Description TODO
 */
public class Test2 {

    public static void main(String[] args) {
        String str = "1";
        double d = Math.random();
        System.out.println(d);
        try {
            if(d > 0.8){
                return;
            }
            if(d > 0.5){
                throw new RuntimeException("exception1");
            }
        } catch (Exception e) {
            str = "2";
            throw new RuntimeException("exception2");
        } finally {
            System.out.println(str);
        }
    }
}
