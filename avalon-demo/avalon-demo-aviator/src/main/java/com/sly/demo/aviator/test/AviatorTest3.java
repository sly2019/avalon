package com.sly.demo.aviator.test;

import com.alibaba.fastjson.JSON;
import com.googlecode.aviator.AviatorEvaluator;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by wj on 2021/7/28
 * @Description 内置函数
 */
@Slf4j
public class AviatorTest3 {

    public static void test1(Map<String, Object> env, String expression){
        Object result = AviatorEvaluator.execute("string.length(str)",env);
        log.info("test1, 参数： {} ， 表达式： {} , 计算结果： {} ", JSON.toJSONString(env),  expression, result);
    }

    public static void main(String[] args) {
        Map<String,Object> env = new HashMap<>();
        env.put("str", "Aviator的内置函数用法");
        test1(env, "string.length(str)");
    }

}
