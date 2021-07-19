package com.sly.base.common.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @Created by wj on 2021/6/24
 * @Description TODO
 */
public class Test5 {

    public static void main(String[] args) {
        String json = "{\"le\": 1, \"gt\": \"6\"}";
        JSONObject o = JSON.parseObject(json);
        Integer le = o.getInteger("le");
        Integer lt = o.getInteger("lt");
        Integer gt = o.getInteger("gt");
        System.out.println(le);
        System.out.println(lt);
        System.out.println(gt);
    }
}
