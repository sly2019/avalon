package com.sly.base.common.container.list.demo1;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Created by wj on 2021/5/31
 * @Description TODO
 */
public class Test1 {

    public static void test1(){
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        list.add("1");
        map.put("1", list);
        System.out.println(JSON.toJSONString(map));
        List<String> l = map.get("1");
        l.add("2");
        System.out.println(JSON.toJSONString(map));
    }

    public static void main(String[] args) {
        test1();
    }



}
