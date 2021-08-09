package com.sly.designpattern.relation.generalization.demo2;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
public class XiaoMing implements Man {
    @Override
    public void run() {
        System.out.println("小明会跑");
    }

    @Override
    public void eat() {
        System.out.println("小明会吃");
    }
}
