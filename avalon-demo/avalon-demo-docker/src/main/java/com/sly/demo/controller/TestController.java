package com.sly.demo.controller;

import com.sly.demo.service.TestService;
import com.sly.demo.vo.TestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author by wj on 2021/6/28 11:03
 * @Description TODO
 */
@Component
@Slf4j
@RestController
@Api(tags = "测试1")
@RequestMapping("/inter-api/base")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/v1/test")
    public List<TestVO> getall(@ApiParam(value = "id", example = "1a2b3c") @RequestParam(value = "id", defaultValue = "2") String id,
                               @ApiParam(value = "名称", example = "测试") @RequestParam(value = "name", required = false, defaultValue = "test") String name){
        return testService.getAll();
    }

}
