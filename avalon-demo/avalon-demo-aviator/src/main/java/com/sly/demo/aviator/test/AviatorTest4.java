package com.sly.demo.aviator.test;

import com.alibaba.fastjson.JSON;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by wj on 2021/7/28
 * @Description 逻辑表达式
 */
@Slf4j
public class AviatorTest4 {

    public static void test1(Map<String, Object> env, String expression){
        Expression compiledExp = AviatorEvaluator.compile(expression);
        Object result = compiledExp.execute(env);
        log.info("test1, 参数： {} ， 表达式： {} , 计算结果： {} ", JSON.toJSONString(env),  expression, result);
    }

    public static void main(String[] args) {
        Map<String, Object> env = new HashMap<>();
        env.put("a", 100.3);
        env.put("b", 45);
        env.put("c", -199.100);
        test1(env, "!(a-(b-c)>100)");
        test1(env, "a-(b-c)<100");
    }

}
