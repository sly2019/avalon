package com.sly.base.common.test;

import com.alibaba.fastjson.JSON;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author by wj on 2021/6/24 9:47
 * @Description TODO
 */
public class Test3 {

    public static void main(String[] args) {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("1", 1);
        System.out.println(JSON.toJSONString(map));
        map.put("1", 2);
        System.out.println(JSON.toJSONString(map));
        map.putIfAbsent("1", 3);
        System.out.println(JSON.toJSONString(map));
    }

}
