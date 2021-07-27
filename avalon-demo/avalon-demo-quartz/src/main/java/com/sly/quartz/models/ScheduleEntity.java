package com.sly.quartz.models;

import lombok.Data;

import java.io.Serializable;

/**
 * @Created by wj on 2021/7/23
 * @Description TODO
 */
@Data
public class ScheduleEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jobName;

    /**
     * 任务组
     */
    private String jobGroup;

    /**
     * cron表达式
     */
    private String cronExpression;

    /**
     * 状态
     */
    private String status;

    /**
     * 描述
     */
    private String description;

    /**
     * 执行任务的类(完整路径,包含包名)
     */
    private String className;

    private Long startTime;

    private Long prevTime;

    private Long nextTime;
    
}