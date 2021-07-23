package com.sly.core.modules.rbac.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.base.utils.Generator;
import com.sly.core.models.PageResponse;
import com.sly.core.modules.rbac.mapper.RbacResourceMapper;
import com.sly.core.modules.rbac.models.RbacResource;
import com.sly.core.modules.rbac.models.dtos.RbacResourceAdd;
import com.sly.core.modules.rbac.querybean.RbacResourceQueryBean;
import com.sly.core.modules.rbac.querywraper.RbacResourceQueryWrapper;
import com.sly.core.modules.rbac.service.RbacResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Created by wj on 2021/7/19
 * @Description TODO
 */
@Service
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

    @Override
    public List<RbacResource> getList(RbacResourceQueryBean queryBean) {
        return rbacResourceMapper.selectList(RbacResourceQueryWrapper.buildQueryWrapper(queryBean));
    }

    @Override
    public PageResponse<RbacResource> getPage(RbacResourceQueryBean queryBean, long pageNo, long pageSize) {
        Page<RbacResource> page = rbacResourceMapper.selectPage(new Page<>(pageNo, pageSize), RbacResourceQueryWrapper.buildQueryWrapper(queryBean));
        return PageResponse.<RbacResource>builder().current(page.getCurrent()).pageSize(page.getSize()).pageTotal(page.getPages()).countTotal(page.getTotal()).list(page.getRecords()).build();
    }

}
