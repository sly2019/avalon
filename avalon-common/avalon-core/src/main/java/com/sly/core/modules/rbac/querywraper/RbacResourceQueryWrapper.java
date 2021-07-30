package com.sly.core.modules.rbac.querywraper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sly.base.utils.SqlUtils;
import com.sly.core.modules.rbac.enums.RbacResourceColumnEnums;
import com.sly.core.modules.rbac.models.RbacResource;
import com.sly.core.modules.rbac.querybean.RbacResourceQueryBean;
import org.apache.commons.lang3.StringUtils;

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

        // pid
        {
            if(!StringUtils.isEmpty(queryBean.getPid())){
                wrapper.eq(RbacResourceColumnEnums.PropertyEnums.pid.name(), queryBean.getPid());
            }
            if(queryBean.getPidIsNull() != null && queryBean.getPidIsNull()){
                wrapper.eq(RbacResourceColumnEnums.PropertyEnums.pid.name(), queryBean.getPid());
            }
        }

        // name
        {
            if(!StringUtils.isEmpty(queryBean.getNameLike())){
                wrapper.like(RbacResourceColumnEnums.PropertyEnums.name.name(), SqlUtils.buildLikeString(queryBean.getNameLike()));
            }
        }


    }


}
