package com.sly.core.modules.rbac.querywraper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sly.core.modules.rbac.models.RbacUser;
import com.sly.core.modules.rbac.querybean.RbacUserQueryBean;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
public class RbacUserQueryWrapper {

    public static QueryWrapper<RbacUser> buildQueryWrapper(RbacUserQueryBean queryBean){
        if(queryBean == null){
            return null;
        }
        QueryWrapper<RbacUser> wrapper = new QueryWrapper<>();
        baseBuild(wrapper, queryBean);
        return wrapper;
    }

    protected static void baseBuild(QueryWrapper<RbacUser> wrapper, RbacUserQueryBean queryBean){

    }
}
