package com.sly.demo.basic.test.threadpool;

/**
 * @Created by wj on 2021/7/23
 * @Description TODO
 */
public class MyThread implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(100 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
