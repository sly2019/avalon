package com.sly.designpattern.pattern.observer.demo1;

import java.util.Observable;
import java.util.Observer;

/**
 * @Created by wj on 2021/5/26
 * @Description TODO
 */
public class Viewer implements Observer {

    private int seatNo;

    public Viewer(int seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public void update(Observable o, Object arg) {
        Integer state = (Integer) arg;
        switch (state) {
            case Clown.PERFORM_GOOD:
                applause();
                break;
            case Clown.PERFORM_BAD:
                CheerBack();
                break;
            case Clown.PERFORM_COMPLETE:
                exit();
                break;
            default:
                break;
        }
    }

    /**
     * 鼓掌
     */
    private void applause() {
        System.out.println("座位号" + getSeatNo() + "的观众鼓掌了！");
    }

    /**
     * 倒喝彩
     */
    private void CheerBack() {
        System.out.println("座位号" + getSeatNo() + "的观众发出了倒喝彩！");
    }

    /**
     * 退场
     */
    private void exit() {
        System.out.println("座位号" + getSeatNo() + "的观众退场！");
    }

    public int getSeatNo() {
        return seatNo;
    }

}
