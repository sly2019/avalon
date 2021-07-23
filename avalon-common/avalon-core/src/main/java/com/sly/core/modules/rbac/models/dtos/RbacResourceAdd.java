package com.sly.core.modules.rbac.models.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Created by wj on 2021/7/19
 * @Description TODO
 */
@Data
@ApiModel
public class RbacResourceAdd {

    @ApiModelProperty(value = "id", required = false, example = "rd34bs78lkj575bn751")
    private String id;

    @ApiModelProperty(value = "pid", required = false, example = "ea34bs34lkj556bn744")
    private String pid;

    @ApiModelProperty(value = "名称", required = true, example = "test")
    private String name;

    @ApiModelProperty(value = "说明", required = false, example = "说明")
    private String description;

}
