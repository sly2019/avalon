package com.sly.demo.aviator.test;

import com.alibaba.fastjson.JSON;
import com.googlecode.aviator.AviatorEvaluator;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by wj on 2021/7/28
 * @Description 变量
 */
@Slf4j
public class AviatorTest2 {

    public static void test1(Map<String, Object> env, String expression){
        Object result = AviatorEvaluator.execute(expression, env);
        log.info("test1, 参数： {} ， 表达式： {} , 计算结果： {} ", JSON.toJSONString(env),  expression, result);
    }

    public static void main(String[] args) {
        Map<String, Object> env1 = new HashMap<>(8);
        env1.put("name", "John");
        test1(env1, "'Hello ' + name + ', welcome to java'");
    }


}
