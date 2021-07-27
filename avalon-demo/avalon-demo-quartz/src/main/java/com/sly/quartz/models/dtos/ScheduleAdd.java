package com.sly.quartz.models.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Created by wj on 2021/7/23
 * @Description TODO
 */
@Data
@ApiModel
public class ScheduleAdd {

    @ApiModelProperty(value = "任务名", required = true, example = "test")
    private String jobName;

    @ApiModelProperty(value = "任务组", required = true, example = "test")
    private String jobGroup;

    @ApiModelProperty(value = "执行任务的类", required = true, example = "com.a.b.c.TestJob")
    private String className;

    @ApiModelProperty(value = "cron表达式", required = true, example = "0 0 1 * * ? *")
    private String cronExpression;

    @ApiModelProperty(value = "说明", required = false, example = "测试")
    private String description;

}
