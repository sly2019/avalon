package com.sly.demo.start;

import com.sly.demo.service.TestService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author by wj on 2021/6/25 18:11
 * @Description TODO
 */
@Component
@Order(value = 1)
public class Start implements ApplicationRunner {

    @Resource
    private TestService testService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("start...");
        testService.run();
        System.out.println("end...");
    }

}

