package com.sly.demo.aviator.test;

import com.alibaba.fastjson.JSON;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorBigInt;
import com.googlecode.aviator.runtime.type.AviatorObject;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created by wj on 2021/7/28
 * @Description 自定义函数
 */
@Slf4j
public class AviatorTest5 {

    static class MinFunction extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
            Number left = FunctionUtils.getNumberValue(arg1, env);
            Number right = FunctionUtils.getNumberValue(arg2, env);
            return new AviatorBigInt(Math.min(left.doubleValue(), right.doubleValue()));
        }

        @Override
        public String getName() {
            return "min";
        }
    }

    public static void test1(Map<String, Object> env, String expression){
        Expression compiledExp = AviatorEvaluator.compile(expression, true);
        Object result = compiledExp.execute(env);
        log.info("test1, 参数： {} ， 表达式： {} , 计算结果： {} ", JSON.toJSONString(env),  expression, result);
    }

    public static void main(String[] args) {
        AviatorEvaluator.addFunction(new MinFunction());
        Map<String, Object> env = new HashMap<>();
        env.put("a", 100.3);
        env.put("b", 45);
        test1(env, "min(a,b)");
    }
}
