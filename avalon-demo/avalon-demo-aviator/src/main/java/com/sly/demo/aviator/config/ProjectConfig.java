package com.sly.demo.aviator.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.pattern.PathPattern;

/**
 * @Created by wj on 2021/7/27
 * @Description TODO
 */
@Configuration
@Data
public class ProjectConfig {

    @Value("${project.test.test1:1}")
    private int test1;

    @Value("${project.test.test2:1}")
    private Integer test2;

    @Value("${project.test.test3:1}")
    private int test3;

    @Value("${project.test.test4:1}")
    private String test4;

    @Value("${project.test.test5:1}")
    private String test5;

    @Value("${project.test.test6:55dd}")
    private String test6;

    @Override
    public String toString() {
        return "ProjectConfig{" +
                "test1=" + test1 +
                ", test2=" + test2 +
                ", test3=" + test3 +
                ", test4='" + test4 + '\'' +
                ", test5='" + test5 + '\'' +
                ", test6='" + test6 + '\'' +
                '}';
    }
}
