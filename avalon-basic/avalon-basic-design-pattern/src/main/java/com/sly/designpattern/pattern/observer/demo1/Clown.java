package com.sly.designpattern.pattern.observer.demo1;

import java.util.Observable;
import java.util.Random;

/**
 * @Created by wj on 2021/5/26
 * @Description TODO
 */
public class Clown extends Observable {

    public static final int PERFORM_GOOD = 0;
    public static final int PERFORM_BAD = 1;
    public static final int PERFORM_COMPLETE = 2;

    /**
     * 表演
     */
    public void perform() {
        System.out.println("**小丑开始表演**");
        int random = new Random().nextInt(10) + 1;
        int flag;
        try {
            Thread.sleep(random * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(random > 5){
            System.out.println("**小丑状态很好，表演了 " + random + " 秒，表演的很精彩！**");
            flag = PERFORM_GOOD;
        } else {
            System.out.println("**小丑状态不好，表演了 " + random + " 秒，出了点篓子！**");
            flag = PERFORM_BAD;
        }
        setChanged();
        //表演好坏通过该参数传递到观众的update方法的第二个参数上
        notifyObservers(flag);
    }

    /**
     * 表演结束,小丑退场
     */
    public void exit() {
        System.out.println("**表演结束，小丑开始退场！**");

        int random = new Random().nextInt(3) + 1;
        try {
            Thread.sleep(random * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("**" + random  + " 秒后，小丑退出了场地！**");
        setChanged();
        //退场消息通过该参数传递到观众的update方法的第二个参数上
        notifyObservers(PERFORM_COMPLETE);
    }

}
