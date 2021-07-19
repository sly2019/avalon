package com.sly.quartz.start;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Created by wj on 2021/6/29
 * @Description TODO
 */
@Slf4j
@Component
public class Listener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("ApplicationListener start...");
        log.info("ApplicationListener end...");
    }
}
