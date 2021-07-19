package com.sly.quartz.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Created by wj on 2021/6/29
 * @Description TODO
 */
@Slf4j
@RestController
@Api(tags = "测试")
@RequestMapping("/demo-quartz/test")
public class TestController {

    @GetMapping("/v1/array")
    @ApiOperation(value = "获取数组")
    public Object geta(String[] ids){
        return JSON.toJSONString(ids);
    }

    @DeleteMapping("/v1/array")
    @ApiOperation(value = "删除数组")
    public Object deletea(String[] ids){
        return JSON.toJSONString(ids);
    }

    @GetMapping("/v1/list")
    @ApiOperation(value = "获取列表")
    public Object getl(@RequestParam List<String> ids){
        return JSON.toJSONString(ids);
    }

    @DeleteMapping("/v1/list")
    @ApiOperation(value = "删除列表")
    public Object deletel(@RequestParam List<String> ids){
        return JSON.toJSONString(ids);
    }

}
