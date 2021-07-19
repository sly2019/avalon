package com.sly.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Created by wj on 2021/7/7 19:03
 * @Description TODO
 */
@Data
@Component
public class ProjectConfig {

    @Value("${project.file.path}")
    private String filePath;

    @Value("${project.test:ttt}")
    private String test;

    public String getFilePath() {
        return filePath + "/";
    }

}
