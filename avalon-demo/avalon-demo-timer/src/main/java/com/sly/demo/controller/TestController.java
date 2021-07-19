package com.sly.demo.controller;

import com.sly.demo.service.MyTask;
import com.sly.demo.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.TimerTask;

/**
 * @Created by wj on 2021/6/25 18:22
 * @Description TODO
 */
@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public String test(){
        testService.pause();
        return "ok";
    }
}
