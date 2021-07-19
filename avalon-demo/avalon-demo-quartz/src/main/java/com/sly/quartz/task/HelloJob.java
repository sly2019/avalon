package com.sly.quartz.task;

import com.sly.quartz.models.ScheduleEntity;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

/**
 * @Created by wj on 2021/6/29
 * @Description DisallowConcurrentExecution注解表示禁用并发，当前任务执行完后，才会进行下一次调度
 */
@Slf4j
@DisallowConcurrentExecution
public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        String jobName = jobKey.getName();
        String jobGroup = jobKey.getGroup();
        log.info(jobGroup + "." + jobName + " start....");
        log.info(jobGroup + "." + jobName + " end....");
    }

}
