package com.sly.base.common.test;

/**
 * @Created by wj on 2021/6/23
 * @Description TODO
 */
public class Test1 {

    public static boolean test(Boolean b){
        if(b){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // NullPointerException
        System.out.println(test(null));
        System.out.println(test(true));
        System.out.println(test(false));
    }
}
