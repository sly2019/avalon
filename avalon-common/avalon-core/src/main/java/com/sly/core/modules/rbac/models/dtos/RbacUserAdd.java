package com.sly.core.modules.rbac.models.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
@Data
@ApiModel
public class RbacUserAdd {

    @ApiModelProperty(value = "用户名", required = true, example = "admin")
    private String userName;

    @ApiModelProperty(value = "名称", required = false, example = "张三")
    private String name;

    @ApiModelProperty(value = "说明", required = false, example = "测试")
    private String description;

}
