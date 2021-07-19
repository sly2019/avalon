package com.sly.demo.service;

import com.sly.demo.models.Test;
import com.sly.demo.vo.TestVO;

import java.util.List;

/**
 * @Created by wj on 2021/6/28
 * @Description TODO
 */
public interface TestService {

    List<TestVO> getAll();

    /**
     * 转换vo
     * @param test
     * @return
     */
    TestVO convertModelToVO(Test test);

    /**
     * 转换vo
     * @param tests
     * @return
     */
    List<TestVO> convertModelToVO(List<Test> tests);

}
