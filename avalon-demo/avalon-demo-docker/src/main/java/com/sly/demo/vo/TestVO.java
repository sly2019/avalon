package com.sly.demo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Created by wj on 2021/6/29
 * @Description TODO
 */
@Data
@ApiModel
public class TestVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

}
