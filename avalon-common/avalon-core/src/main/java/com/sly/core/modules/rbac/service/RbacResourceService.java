package com.sly.core.modules.rbac.service;

import com.sly.core.models.PageResponse;
import com.sly.core.modules.rbac.models.RbacResource;
import com.sly.core.modules.rbac.models.dtos.RbacResourceAdd;
import com.sly.core.modules.rbac.querybean.RbacResourceQueryBean;

import java.util.List;

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

    /**
     * 获取列表
     * @param queryBean
     * @return
     */
    List<RbacResource> getList(RbacResourceQueryBean queryBean);

    /**
     * 获取分页列表
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageResponse<RbacResource> getPage(RbacResourceQueryBean queryBean, long pageNo, long pageSize);


}
