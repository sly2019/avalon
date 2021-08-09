package com.sly.designpattern.relation.generalization.demo2;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
public class Test {

    public static void main(String[] args) {
        Woman woman = new Woman();
        XiaoHong xiaoHong = new XiaoHong();
        XiaoLi xiaoLi = new XiaoLi();
        XiaoMing xiaoMing = new XiaoMing();
        woman.eat();
        xiaoHong.eat();
        xiaoLi.eat();
        xiaoMing.eat();
        xiaoMing.run();
    }

}
