package com.sly.core.modules.rbac.querybean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Created by wj on 2021/7/19
 * @Description TODO
 */
@Data
public class RbacResourceQueryBean {

    @ApiModelProperty(value = "pid", required = false, example = "ea34bs34lkj556bn744")
    private String pid;

    @ApiModelProperty(value = "pid为空", required = false, example = "true")
    private Boolean pidIsNull;

    @ApiModelProperty(value = "名称", required = true, example = "test")
    private String nameLike;


}
