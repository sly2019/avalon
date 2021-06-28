package com.sly.base.common.test;

import com.alibaba.fastjson.JSON;

/**
 * @Author by wj on 2021/6/24 13:24
 * @Description TODO
 */
public class Test4 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(CheckType.valueOf("区间")));
        System.out.println(JSON.toJSONString(CheckType.valueOf("enum")));
        System.out.println(JSON.toJSONString(CheckType.valueOf("2")));
        System.out.println(JSON.toJSONString(CheckType.valueOf("")));
        System.out.println(JSON.toJSONString(CheckType.valueOf(null)));
    }

}
