package com.sly.core.modules.rbac.service;

import com.sly.core.models.PageResponse;
import com.sly.core.modules.rbac.models.RbacUser;
import com.sly.core.modules.rbac.models.dtos.RbacUserAdd;
import com.sly.core.modules.rbac.models.vo.RbacUserVO;
import com.sly.core.modules.rbac.querybean.RbacUserQueryBean;

import java.util.List;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
public interface RbacUserService {

    /**
     * 添加用户
     * @param rbacUserAdd
     */
    void add(RbacUserAdd rbacUserAdd);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    RbacUser getById(String id);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    RbacUserVO getVOById(String id);

    /**
     * 查询
     * @param queryBean
     * @return
     */
    List<RbacUser> getAll(RbacUserQueryBean queryBean);

    /**
     * 查询
     * @param queryBean
     * @return
     */
    List<RbacUserVO> getAllVO(RbacUserQueryBean queryBean);

    /**
     * 分页查询
     * @param queryBean
     * @return
     */
    PageResponse<RbacUser> getPage(RbacUserQueryBean queryBean, long pageSize, long pageNo);

    /**
     * 分页查询
     * @param queryBean
     * @return
     */
    PageResponse<RbacUserVO> getPageVO(RbacUserQueryBean queryBean, long pageSize, long pageNo);

    /**
     * 删除用户
     * @param id
     */
    void del(String id);

    /**
     * 转换vo
     * @param rbacUser
     * @return
     */
    RbacUserVO convertToVO(RbacUser rbacUser);

    /**
     * 转换vo
     * @param rbacUsers
     * @return
     */
    List<RbacUserVO> convertToVO(List<RbacUser> rbacUsers);

}
