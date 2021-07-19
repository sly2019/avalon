package com.sly.demo.controller;

import com.sly.demo.config.ProjectConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author by wj on 2021/7/9 9:01
 * @Description TODO
 */
@RestController
public class TestController {

    @Resource
    private ProjectConfig projectConfig;

    @GetMapping("/test")
    public Object test(){
        return projectConfig.getTest();
    }
}
