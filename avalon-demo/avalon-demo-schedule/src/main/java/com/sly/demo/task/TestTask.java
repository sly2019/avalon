package com.sly.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Created by wj on 2021/7/1
 * @Description Scheduled为单线程
 */
@Slf4j
@Component
public class TestTask {

    /**
     * 每秒执行一次
     * 序号,说明,必填,允许填写的值,允许的通配符
     * 1,秒,是,0-59
     * 2,分,是,0-59, - * /
     * 3,时,是,0-23, - * /
     * 4,日,是,1-31, - * ? / L W
     * 5,月,是,1-12 / JAN-DEC, - * /
     * 6,周,是,1-7 or SUN-SAT, - * ? / L #
     * 7,年,否,1970-2099, - * /
     */
    @Scheduled(cron = "0/1 * * * * ?")
    public void task1(){
        log.info("test task1 stat...");
        log.info("test task1 end.");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void task2(){
        log.info("test task2 stat...");
        try {
            Thread.sleep(10000);
        } catch (Exception e){
            e.printStackTrace();
        }
      log.info("test task2end.");
    }


}
