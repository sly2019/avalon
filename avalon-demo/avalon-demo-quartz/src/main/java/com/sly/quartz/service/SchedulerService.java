package com.sly.quartz.service;

import com.sly.quartz.models.ScheduleEntity;
import com.sly.quartz.models.dtos.ScheduleAdd;

import java.util.List;

/**
 * @Created by wj on 2021/7/23
 * @Description TODO
 */
public interface SchedulerService {

    /**
     * 添加
     * @param scheduleAdd
     */
    void add(ScheduleAdd scheduleAdd);

    /**
     * 获取所有计划中的任务
     * @return
     */
    List<ScheduleEntity> getAllScheduleJob();

}
