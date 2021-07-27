package com.sly.quartz.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(QuartzProperties.class)
public class SchedulerConfig {

    @Bean(name="Scheduler")
    public Scheduler scheduler() throws SchedulerException {
        return StdSchedulerFactory.getDefaultScheduler();
    }

}
