package com.sly.designpattern.module.observer.demo1;

/**
 * @Created by wj on 2021/5/26
 * @Description TODO
 */
public class Test1 {

    public static void main(String[] args) {
        //来了一个小丑
        Clown clown = new Clown();
        //观众入场了
        for (int i = 0; i < 2; i++) {
            Viewer v = new Viewer(i);
            clown.addObserver(v);
            System.out.println("座号为"+v.getSeatNo()+"的观众入座");
        }
        //小丑开始表演
        System.out.println("呼叫小丑演出start");
        clown.perform();
        System.out.println("呼叫小丑演出over");
        //小丑表演完毕，退场
        System.out.println("呼叫小丑退场start");
        clown.exit();
        System.out.println("呼叫小丑退场over");
    }
}
