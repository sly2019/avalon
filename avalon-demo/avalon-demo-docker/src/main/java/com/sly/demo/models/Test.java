package com.sly.demo.models;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @Created by wj on 2021/6/28
 * @Description TODO
 */
@Data
@Builder
@ApiModel
@AllArgsConstructor
@TableName("demo_docker_test")
public class Test {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}
