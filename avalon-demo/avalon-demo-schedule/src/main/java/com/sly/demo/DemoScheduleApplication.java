package com.sly.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author by wj on 2021/7/1 11:21
 * @Description TODO
 */
@SpringBootApplication
@EnableScheduling
public class DemoScheduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoScheduleApplication.class);
    }

}
