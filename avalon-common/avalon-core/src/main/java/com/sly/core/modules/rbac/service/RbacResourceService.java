package com.sly.core.modules.rbac.service;

import com.sly.core.modules.rbac.models.dtos.RbacResourceAdd;

/**
 * @Created by wj on 2021/7/19
 * @Description TODO
 */
public interface RbacResourceService {

    /**
     * 新增
     * @param rbacResourceAdd
     */
    void add(RbacResourceAdd rbacResourceAdd);


}
