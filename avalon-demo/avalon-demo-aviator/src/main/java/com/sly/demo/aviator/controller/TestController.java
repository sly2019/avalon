package com.sly.demo.aviator.controller;

import com.sly.demo.aviator.config.ProjectConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Created by wj on 2021/7/27
 * @Description TODO
 */
@RestController
public class TestController {

    @Autowired
    private ProjectConfig projectConfig;

    @RequestMapping("/test")
    public Object test(){
        return projectConfig.toString();
    }

}
