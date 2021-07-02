package com.sly.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author by wj on 2021/5/26 18:15
 * @Description TODO
 */
@SpringBootApplication
@EnableSwagger2
public class DemoQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoQuartzApplication.class);
    }

}
