package com.sly.demo.service;

import java.util.Date;
import java.util.TimerTask;

/**
 * @Author by wj on 2021/6/25 18:18
 * @Description TODO
 */
public class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println(new Date());
    }
}
