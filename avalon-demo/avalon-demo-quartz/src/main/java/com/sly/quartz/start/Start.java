package com.sly.quartz.start;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Created by wj on 2021/6/29
 * @Description TODO
 */
@Slf4j
@Component
public class Start implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("ApplicationRunner start...");
        log.info("ApplicationRunner end...");
    }

}
