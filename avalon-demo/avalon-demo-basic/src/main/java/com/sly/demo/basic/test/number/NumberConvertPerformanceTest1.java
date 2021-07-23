package com.sly.demo.basic.test.number;

import lombok.extern.slf4j.Slf4j;

/**
 * @Created by wj on 2021/7/23
 * @Description TODO
 *
 *  字符转浮点：1秒约3千万次计算
 *  字符转数值，30000000次，总计耗时：1.18
 *  字符转数值，30000000次，总计耗时：0.925
 *  字符转数值，30000000次，总计耗时：0.916
 *  字符转数值，30000000次，总计耗时：0.918
 *  字符转数值，30000000次，总计耗时：0.923
 *
 *
 */
@Slf4j
public class NumberConvertPerformanceTest1 {

    public static void str2Double(String ds, long count){
        long t1 = System.currentTimeMillis();
        for(long l = 0; l < count; l++){
            try {
                Double.valueOf(ds);
            }catch (Exception e){
            }
        }
        long t2 = System.currentTimeMillis();
        log.info("字符转数值，{}次，总计耗时：{}", count, (t2 - t1) / 1000.0);
    }

    public static void main(String[] args) {
        String ds = "123.567";
        long count = 1L * 3000 * 10000;
        for(int i = 0; i < 5; i++){
            str2Double(ds, count);
        }
    }


}
