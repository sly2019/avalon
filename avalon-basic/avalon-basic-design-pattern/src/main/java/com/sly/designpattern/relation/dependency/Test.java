package com.sly.designpattern.relation.dependency;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
public class Test {

    public static void main(String[] args) {
        Book book = new Book();
        book.setName("上下五千年");
        Food food = new Food();
        food.setName("西瓜");
        Human human = new Human();
        human.eat(food);
        human.read(book);
    }

}
