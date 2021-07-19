package com.sly.quartz.controller;

import com.sly.quartz.base.common.Response;
import com.sly.quartz.task.HelloJob;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by wj on 2021/6/29
 * @Description TODO
 */
@Slf4j
@RestController
@RequestMapping("/demo-quartz/schedule")
public class ScheduleController {

    @PostMapping("/v1/test/schedule")
    public Response testAdd(String jobName, String jobGroup){
        try {
            //获取一个调度程序实例
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            log.info("scheduler: {}-{}", scheduler.getSchedulerInstanceId(), scheduler.getSchedulerName());
            scheduler.getContext().put("skey", "svalue");
            //创建一个触发器
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger1", "group1")
                    .usingJobData("t1", "tv1")
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever())
                    .build();
            trigger.getJobDataMap().put("t2", "tv2");
            //创建一个job
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                    .usingJobData("j1", "jv1")
                    .withIdentity(jobName, jobGroup)
                    .build();
            jobDetail.getJobDataMap().put("j2", "jv2");
            //注册trigger并启动schedule
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
            return Response.error();
        }
        return Response.ok();
    }


}
