package com.sly.core.modules.rbac.service.impl;

import com.sly.base.utils.Generator;
import com.sly.core.modules.rbac.mapper.RbacResourceMapper;
import com.sly.core.modules.rbac.models.RbacResource;
import com.sly.core.modules.rbac.models.dtos.RbacResourceAdd;
import com.sly.core.modules.rbac.service.RbacResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Created by wj on 2021/7/19
 * @Description TODO
 */
public class RbacResourceServiceImpl implements RbacResourceService {

    @Autowired
    private RbacResourceMapper rbacResourceMapper;

    @Override
    public void add(RbacResourceAdd rbacResourceAdd) {
        RbacResource resource = new RbacResource();
        BeanUtils.copyProperties(rbacResourceAdd, resource);
        resource.setId(Generator.genUUID());
        resource.setCreatedTime(new Date());
        rbacResourceMapper.insert(resource);
    }


}
