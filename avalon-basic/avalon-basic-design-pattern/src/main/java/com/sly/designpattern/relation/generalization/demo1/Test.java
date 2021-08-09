package com.sly.designpattern.relation.generalization.demo1;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
public class Test {

    public static void main(String[] args) {
        Animal animal = new Animal();
        Bird bird = new Bird();
        Fish fish = new Fish();
        Cat cat = new Cat();
        animal.eat();
        bird.eat();
        bird.fly();
        fish.eat();
        fish.swim();
        cat.eat();
        cat.run();
    }
}
