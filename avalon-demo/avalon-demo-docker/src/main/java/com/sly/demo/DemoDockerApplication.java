package com.sly.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author by wj on 2021/6/28 9:00
 * @Description TODO
 */
@SpringBootApplication
@MapperScan("com.sly.demo.mapper")
@EnableSwagger2
public class DemoDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDockerApplication.class);
    }

}
