package com.sly.demo.basic.test.loop;

import lombok.extern.slf4j.Slf4j;

/**
 * @Created by wj on 2021/7/23
 * @Description 不同循环嵌套数的性能比较
 *  总的来说，单词循环效率性能较高且稳定
 *
 *  一次循环(10000000000)计算耗时:2.638
 *  二次循环(1*10000000000)计算耗时:2.558
 *  二次循环(10*1000000000)计算耗时:3.178
 *  二次循环(100*100000000)计算耗时:5.082
 *  三次循环(1*1*10000000000)计算耗时:5.085
 *  三次循环(10*1000*1000000)计算耗时:2.544
 *
 *  一次循环(10000000000)计算耗时:2.541
 *  二次循环(1*10000000000)计算耗时:5.085
 *  二次循环(10*1000000000)计算耗时:5.084
 *  二次循环(100*100000000)计算耗时:5.079
 *  三次循环(1*1*10000000000)计算耗时:2.535
 *  三次循环(10*1000*1000000)计算耗时:2.541
 *
 *  一次循环(10000000000)计算耗时:2.535
 *  二次循环(1*10000000000)计算耗时:5.081
 *  二次循环(10*1000000000)计算耗时:5.085
 *  二次循环(100*100000000)计算耗时:5.08
 *  三次循环(1*1*10000000000)计算耗时:2.541
 *  三次循环(10*1000*1000000)计算耗时:2.538
 *
 */
@Slf4j
public class LoopPerformanceTest1 {

    public static void oneLoop(long count){
        long res = 0;
        long t1 = System.currentTimeMillis();
        for(long i = 0; i < count; i++){
            res++;
        }
        long t2 = System.currentTimeMillis();
        log.info("一次循环({})计算耗时:{}", count, ( t2 - t1) / 1000.0);
    }

    public static void twoLoop(long c1, long c2){
        long res = 0;
        long t1 = System.currentTimeMillis();
        for(long i = 0; i < c1; i++){
            for(long j = 0; j < c2; j++){
                res++;
            }
        }
        long t2 = System.currentTimeMillis();
        log.info("二次循环({}*{})计算耗时:{}", c1, c2, ( t2 - t1) / 1000.0);
    }

    public static void tripleLoop(long c1, long c2, long c3){
        long res = 0;
        long t1 = System.currentTimeMillis();
        for(long i = 0; i < c1; i++){
            for(long j = 0; j < c2; j++){
               for(long k = 0; k < c3; k++){
                   res++;
               }
            }
        }
        long t2 = System.currentTimeMillis();
        log.info("三次循环({}*{}*{})计算耗时:{}", c1, c2, c3, ( t2 - t1) / 1000.0);
    }

    public static void main(String[] args) {
        oneLoop(10L * 1000 * 1000 * 1000);
        twoLoop(1, 10L * 1000 * 1000 * 1000);
        twoLoop(10, 1L * 1000 * 1000 * 1000);
        twoLoop(100, 100L * 1000 * 1000);
        tripleLoop(1, 1, 10L * 1000 * 1000 * 1000);
        tripleLoop(10, 1000, 1000 * 1000);
        log.info("");
        oneLoop(10L * 1000 * 1000 * 1000);
        twoLoop(1, 10L * 1000 * 1000 * 1000);
        twoLoop(10, 1L * 1000 * 1000 * 1000);
        twoLoop(100, 100L * 1000 * 1000);
        tripleLoop(1, 1, 10L * 1000 * 1000 * 1000);
        tripleLoop(10, 1000, 1000 * 1000);
        log.info("");
        oneLoop(10L * 1000 * 1000 * 1000);
        twoLoop(1, 10L * 1000 * 1000 * 1000);
        twoLoop(10, 1L * 1000 * 1000 * 1000);
        twoLoop(100, 100L * 1000 * 1000);
        tripleLoop(1, 1, 10L * 1000 * 1000 * 1000);
        tripleLoop(10, 1000, 1000 * 1000);
    }
}
