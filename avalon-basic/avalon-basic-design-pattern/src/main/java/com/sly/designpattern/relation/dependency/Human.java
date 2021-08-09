package com.sly.designpattern.relation.dependency;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
public class Human {

    public void read(Book book){
        System.out.println("看" + book.getName());
    }

    public void eat(Food food){
        System.out.println("吃" + food.getName());
    }
}
