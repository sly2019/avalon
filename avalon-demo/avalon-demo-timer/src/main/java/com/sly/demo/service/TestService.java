package com.sly.demo.service;

import org.springframework.stereotype.Service;

import java.util.Timer;

/**
 * @Author by wj on 2021/6/25 18:14
 * @Description TODO
 */
@Service
public class TestService {
    private Timer t ;

    public void run(){
        t = new Timer();
        MyTask task = new MyTask();
        t.schedule(task, 1000,1000);
    }

    public void pause(){
        t.cancel();
        t = new Timer();
        MyTask task = new MyTask();
        t.schedule(task, 1000,5000);
    }

}
