package com.sly.core.modules.rbac.models;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Created by wj on 2021/7/19
 * @Description TODO
 */
@Data
@Builder
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
@TableName("rbac_role")
public class RbacRole {
}
