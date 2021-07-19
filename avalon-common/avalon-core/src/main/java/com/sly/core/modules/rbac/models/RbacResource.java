package com.sly.core.modules.rbac.models;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Created by wj on 2021/7/19
 * @Description TODO
 */
@Data
@Builder
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@TableName("rbac_resource")
public class RbacResource implements Serializable{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "pid")
    private Integer pid;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "资源uri")
    private String uri;

    @ApiModelProperty(value = "类型")
    private String type;

    @ApiModelProperty(value = "排序号")
    private Double sequence;

    @ApiModelProperty(value = "说明")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;

}
