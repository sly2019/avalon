package com.sly.demo.aviator.test;

import com.googlecode.aviator.AviatorEvaluator;
import lombok.extern.slf4j.Slf4j;

/**
 * @Created by wj on 2021/7/28
 * @Description aviator基本计算
 * Aviator只支持四种数字类型（2.3.0之后的版本）：Long、Double、big int、decimal
 * 理论上任何整数都将转换成Long（超过Long范围的，将自动转换为big int），任何浮点数都将转换为Double
 * 以大写字母N为后缀的整数都被认为是big int，如1N,2N,9999999999999999999999N等，都是big int类型。
 * 以大写字母M为后缀的数字都被认为是decimal，如1M,2.222M, 100000.9999M等等，都是decimal类型。
 */
@Slf4j
public class AviatorTest1 {

    public static void test1(String expression){
        Object result = AviatorEvaluator.execute(expression);
        log.info("test1, 表达式： {} , 计算结果： {} ", expression, result);
    }

    public static void main(String[] args) {
        test1("(9-(2+1))/2-(2*3+4)");

        /**
         * ~ 对位求反
         * ~1 = -2, ~2 = -3, ~8 = -9
         */
        test1("~1");
        test1("~2");
        test1("~8");

        /**
         * ^ 跟 | 类似，但如果两个操作位都为1的话，结果产生0
         * 2^10 = 8, 2^1 = 3, 2^2 = 0
         */
        test1("2^10");
        test1("2^1");
        test1("2^2");
        test1("1^5");
        test1("9^6");

    }

}
