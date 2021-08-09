package com.sly.core.modules.rbac.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sly.base.utils.Generator;
import com.sly.core.exception.ServiceException;
import com.sly.core.models.PageResponse;
import com.sly.core.modules.rbac.mapper.RbacUserMapper;
import com.sly.core.modules.rbac.models.RbacUser;
import com.sly.core.modules.rbac.models.dtos.RbacUserAdd;
import com.sly.core.modules.rbac.models.vo.RbacUserVO;
import com.sly.core.modules.rbac.querybean.RbacUserQueryBean;
import com.sly.core.modules.rbac.querywraper.RbacUserQueryWrapper;
import com.sly.core.modules.rbac.service.RbacUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Created by wj on 2021/8/9
 * @Description TODO
 */
public class RbacUserServiceImpl implements RbacUserService {

    @Autowired
    private RbacUserMapper rbacUserMapper;

    @Override
    public void add(RbacUserAdd rbacUserAdd) {
        RbacUser rbacUser = new RbacUser();
        BeanUtils.copyProperties(rbacUserAdd, rbacUser);
        rbacUser.setId(Generator.genUUID());
        rbacUser.setCreatedTime(new Date());
        rbacUserMapper.insert(rbacUser);
    }

    @Override
    public RbacUser getById(String id) {
        return rbacUserMapper.selectById(id);
    }

    @Override
    public RbacUserVO getVOById(String id) {
        RbacUser user = getById(id);
        return null;
    }

    @Override
    public List<RbacUser> getAll(RbacUserQueryBean queryBean) {
        return rbacUserMapper.selectList(RbacUserQueryWrapper.buildQueryWrapper(queryBean));
    }

    @Override
    public List<RbacUserVO> getAllVO(RbacUserQueryBean queryBean) {
        return convertToVO(getAll(queryBean));
    }

    @Override
    public PageResponse<RbacUser> getPage(RbacUserQueryBean queryBean, long pageSize, long pageNo) {
        Page<RbacUser> page = new Page<>(pageNo, pageSize);
        page = rbacUserMapper.selectPage(page, RbacUserQueryWrapper.buildQueryWrapper(queryBean));
        return PageResponse.<RbacUser>builder()
                .current(page.getCurrent())
                .pageSize(page.getSize())
                .pageTotal(page.getPages())
                .countTotal(page.getTotal())
                .list(page.getRecords())
                .build();
    }

    @Override
    public PageResponse<RbacUserVO> getPageVO(RbacUserQueryBean queryBean, long pageSize, long pageNo) {
        PageResponse<RbacUser> pageResponse = getPage(queryBean, pageSize, pageNo);
        return PageResponse.<RbacUserVO>builder()
                .current(pageResponse.getCurrent())
                .pageSize(pageResponse.getPageSize())
                .pageTotal(pageResponse.getPageTotal())
                .countTotal(pageResponse.getCountTotal())
                .list(convertToVO(pageResponse.getList()))
                .build();
    }

    @Override
    public void del(String id) {
        RbacUser user = rbacUserMapper.selectById(id);
        if(user == null){
            throw new ServiceException(409, "用户不存在，请刷新后再试");
        }
        rbacUserMapper.deleteById(id);
    }

    @Override
    public RbacUserVO convertToVO(RbacUser rbacUser) {
        if(rbacUser == null){
            return null;
        }
        RbacUserVO vo = new RbacUserVO();
        BeanUtils.copyProperties(rbacUser, vo);
        return vo;
    }

    @Override
    public List<RbacUserVO> convertToVO(List<RbacUser> rbacUsers) {
        if(CollectionUtils.isEmpty(rbacUsers)){
            return null;
        }
        List<RbacUserVO> vos = new ArrayList<>();
        rbacUsers.forEach(s -> {
            RbacUserVO vo = convertToVO(s);
            if(vo != null){
                vos.add(vo);
            }
        });
        return vos;
    }
}
