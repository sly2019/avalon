package com.sly.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Created by wj on 2021/7/20
 * @Description TODO
 */
@SpringBootApplication
@MapperScan("com.sly.core.modules.*.mapper")
@EnableSwagger2
public class CoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class);
    }

}
