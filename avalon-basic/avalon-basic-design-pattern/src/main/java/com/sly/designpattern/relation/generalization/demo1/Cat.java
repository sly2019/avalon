package com.sly.designpattern.relation.generalization.demo1;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
public class Cat extends Animal {

    public void run(){
        System.out.println("猫会跑");
    }

    @Override
    public void eat(){
        System.out.println("猫会吃");
    }
}
