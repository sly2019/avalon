package com.sly.designpattern.module.observer.demo1;

/**
 * @Author by wj on 2021/5/26 10:39
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
        clown.perform();
        //小丑表演完毕，退场
        clown.exit();
    }
}
