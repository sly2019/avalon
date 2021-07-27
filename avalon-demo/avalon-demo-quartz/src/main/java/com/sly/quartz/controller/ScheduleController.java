package com.sly.quartz.controller;

import com.sly.quartz.base.common.Response;
import com.sly.quartz.models.ScheduleEntity;
import com.sly.quartz.models.dtos.ScheduleAdd;
import com.sly.quartz.service.SchedulerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created by wj on 2021/6/29
 * @Description TODO
 */
@Slf4j
@RestController
@Api(tags = "定时任务")
@RequestMapping("/demo-quartz")
public class ScheduleController {

    @Autowired
    private SchedulerService schedulerService;

    /**
     * 新增定时任务
     * @param scheduleAdd
     * @return
     */
    @PostMapping("/v1/schedule")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "新增定时任务")
    public Response add(@RequestBody ScheduleAdd scheduleAdd){
        schedulerService.add(scheduleAdd);
        return Response.ok();
    }

    /**
     * 新增定时任务
     * @return
     */
    @GetMapping("/v1/schedule/all")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "新增定时任务")
    public Response<List<ScheduleEntity>> getAll(){
        return Response.ok(schedulerService.getAllScheduleJob());
    }


}
