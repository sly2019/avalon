package com.sly.designpattern.relation.realization;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
public class Xiaoming implements Doctor, Teacher {
    @Override
    public void operation() {
        System.out.println("xiaoming operation");
    }

    @Override
    public void teach() {
        System.out.println("xiaoming teach");
    }

}
