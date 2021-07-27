package com.sly.quartz.service.impl;

import com.sly.quartz.base.common.exception.ServiceException;
import com.sly.quartz.models.ScheduleEntity;
import com.sly.quartz.models.dtos.ScheduleAdd;
import com.sly.quartz.service.SchedulerService;
import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Created by wj on 2021/7/23
 * @Description TODO
 */
@Service
public class SchedulerServiceImpl implements SchedulerService {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void add(ScheduleAdd scheduleAdd) {
        Class jobClass = null;
        try {
            jobClass = Class.forName(scheduleAdd.getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServiceException(409, e.getMessage());
        }

        JobDetail jobDetail = JobBuilder.newJob(jobClass)
                .withIdentity(scheduleAdd.getJobName(), scheduleAdd.getJobGroup())
                .withDescription(scheduleAdd.getDescription())
                .usingJobData("className", scheduleAdd.getClassName())
                .usingJobData("description", scheduleAdd.getDescription())
                .build();
        jobDetail.getJobDataMap().put("scheduleEntity", scheduleAdd);

        // 表达式调度构建器（可判断创建SimpleScheduleBuilder）
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder
                .cronSchedule(scheduleAdd.getCronExpression());

        // 按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(scheduleAdd.getJobName(), scheduleAdd.getJobGroup())
                .withSchedule(scheduleBuilder).build();
        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            if(e instanceof ObjectAlreadyExistsException){
                throw new ServiceException(409, scheduleAdd.getJobGroup() + "." + scheduleAdd.getJobName() + " 已存在");
            } else {
                e.printStackTrace();
                throw new ServiceException(409, e.getMessage());
            }
        }
    }

    @Override
    public List<ScheduleEntity> getAllScheduleJob() {
        List<ScheduleEntity> scheduleEntityList = new ArrayList<ScheduleEntity>();
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
        try {
            Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
            for (JobKey jobKey : jobKeys) {
                List<? extends Trigger> triggers = scheduler
                        .getTriggersOfJob(jobKey);
                for (Trigger trigger : triggers) {
                    ScheduleEntity scheduleEntity = new ScheduleEntity();
                    scheduleEntity.setJobName(jobKey.getName());
                    scheduleEntity.setJobGroup(jobKey.getGroup());
                    Trigger.TriggerState triggerState = scheduler
                            .getTriggerState(trigger.getKey());
                    scheduleEntity.setStatus(triggerState.name());
                    // 获取要执行的定时任务类名
                    JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                    //获取class及method
                    JobDataMap dataMap = jobDetail.getJobDataMap();
                    scheduleEntity.setClassName(dataMap.getString("className"));
                    scheduleEntity.setDescription(dataMap.getString("description"));
                    // 判断trigger
                    if (trigger instanceof SimpleTrigger) {
                        SimpleTrigger simple = (SimpleTrigger) trigger;
                        scheduleEntity.setCronExpression("重复次数:"
                                + (simple.getRepeatCount() == -1 ? "无限" : simple
                                .getRepeatCount()) + ",重复间隔:"
                                + (simple.getRepeatInterval() / 1000L));
                    }
                    if (trigger instanceof CronTrigger) {
                        CronTrigger cron = (CronTrigger) trigger;
                        scheduleEntity.setCronExpression(cron.getCronExpression());
                    }
                    scheduleEntityList.add(scheduleEntity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scheduleEntityList;
    }
}
