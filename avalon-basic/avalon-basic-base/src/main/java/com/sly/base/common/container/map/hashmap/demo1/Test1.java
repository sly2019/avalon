package com.sly.base.common.container.map.hashmap.demo1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author by wj on 2021/5/28 15:16
 * @Description TODO
 */
public class Test1 {

    /**
     * test putIfAbsent
     */
    public static void test1(){
        Map<String, Object> map = new HashMap<>();
        map.put("1", 1);
        System.out.println(JSON.toJSONString(map));
        System.out.println(map.putIfAbsent("1", 2));
        System.out.println(JSON.toJSONString(map));
        System.out.println(map.putIfAbsent("2", 2));
        System.out.println(JSON.toJSONString(map));
    }

    public static void main(String[] args) {
        test1();
    }
}
