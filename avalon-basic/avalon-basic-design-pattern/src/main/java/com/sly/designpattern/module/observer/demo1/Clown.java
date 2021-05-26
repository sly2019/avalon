package com.sly.designpattern.module.observer.demo1;

import java.util.Observable;
import java.util.Random;

/**
 * @Author by wj on 2021/5/26 10:33
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

        int random = new Random().nextInt(2);
        //小丑表演状态是随机值，0表演的好，1表演的差
        switch (random) {
            case PERFORM_GOOD:
                System.out.println("**小丑状态很好，表演的很精彩！**");
                break;
            case PERFORM_BAD:
                System.out.println("**小丑状态不好，出了点篓子！**");
                break;
        }
        setChanged();
        //表演好坏通过该参数传递到观众的update方法的第二个参数上
        notifyObservers(random);
    }

    /**
     * 表演结束,小丑退场
     */
    public void exit() {
        System.out.println("**表演结束，小丑退场！**");
        setChanged();
        //退场消息通过该参数传递到观众的update方法的第二个参数上
        notifyObservers(PERFORM_COMPLETE);
    }

}
