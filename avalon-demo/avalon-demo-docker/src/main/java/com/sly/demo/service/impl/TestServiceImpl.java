package com.sly.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sly.demo.mapper.TestMapper;
import com.sly.demo.models.Test;
import com.sly.demo.service.TestService;
import com.sly.demo.vo.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author by wj on 2021/6/28 15:19
 * @Description TODO
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<TestVO> getAll() {
        List<TestVO> vos = convertModelToVO(testMapper.selectList(new QueryWrapper<>()));
        log.info(JSON.toJSONString(vos));
        return vos;
    }

    @Override
    public TestVO convertModelToVO(Test test) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TestVO vo = new TestVO();
        BeanUtils.copyProperties(test, vo);
        vo.setCreateTime(sdf.format(test.getCreateTime()));
        return vo;
    }

    @Override
    public List<TestVO> convertModelToVO(List<Test> tests) {
        List<TestVO> vos = new ArrayList<>();
        for(Test t : tests){
            vos.add(convertModelToVO(t));
        }
        return vos;
    }
}
