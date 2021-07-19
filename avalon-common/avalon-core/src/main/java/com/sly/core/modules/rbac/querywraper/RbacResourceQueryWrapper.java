package com.sly.core.modules.rbac.querywraper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sly.core.modules.rbac.models.RbacResource;
import com.sly.core.modules.rbac.querybean.RbacResourceQueryBean;

/**
 * @Created by wj on 2021/7/19
 * @Description TODO
 */
public class RbacResourceQueryWrapper {

    public static QueryWrapper<RbacResource> buildQueryWrapper(RbacResourceQueryBean queryBean){
        if(queryBean == null){
            return null;
        }
        QueryWrapper<RbacResource> wrapper = new QueryWrapper<>();
        baseBuild(wrapper, queryBean);
        return wrapper;
    }

    protected static void baseBuild(QueryWrapper<RbacResource> wrapper, RbacResourceQueryBean queryBean){

    }


}
