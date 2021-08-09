package com.sly.core.modules.rbac.models;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Created by wj on 2021/7/19
 * @Description TODO
 */
@Data
@TableName("rbac_resource")
public class RbacResource implements Serializable{

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private String id;

    /**
     * pid
     */
    private Integer pid;

    /**
     * 名称
     */
    private String name;

    /**
     * 资源uri
     */
    private String uri;

    /**
     * 类型
     */
    private String type;

    /**
     * 排序号
     */
    private Double sequence;

    /**
     * 说明
     */
    private String description;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

}
