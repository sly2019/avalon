package com.sly.demo.basic.test.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @Created by wj on 2021/7/23
 * @Description json 性能测试
 *
 *  fastJson转换700b字符为JSON对象，1秒约20万次
 *  fastJson字符转JSON对象，200000次，总计耗时：1.465
 *  fastJson字符转JSON对象，200000次，总计耗时：1.048
 *  fastJson字符转JSON对象，200000次，总计耗时：1.05
 *  fastJson字符转JSON对象，200000次，总计耗时：1.043
 *  fastJson字符转JSON对象，200000次，总计耗时：1.056
 *
 *  fastJson转换150k字符为JSON对象，1秒约1500次
 *  fastJson字符转JSON对象，1500次，总计耗时：1.097
 *  fastJson字符转JSON对象，1500次，总计耗时：0.871
 *  fastJson字符转JSON对象，1500次，总计耗时：0.87
 *  fastJson字符转JSON对象，1500次，总计耗时：0.866
 *  fastJson字符转JSON对象，1500次，总计耗时：0.845
 */
@Slf4j
public class JsonConvertPrformanceTest1 {

    private static final String FILE_PATH = "D:\\jsonStr.txt";

    public static void fastJsonConvert(String jsonStr, long count){
        long t1 = System.currentTimeMillis();
        for(long l = 0; l < count; l++){
            try {
                JSON.parseObject(jsonStr);
            }catch (Exception e){
            }
        }
        long t2 = System.currentTimeMillis();
        log.info("fastJson字符转JSON对象，{}次，总计耗时：{}", count, (t2 - t1) / 1000.0);
    }

    public static void main(String[] args) {
        String line = "";
        try (BufferedReader br = Files.newBufferedReader(Paths.get(FILE_PATH))) {
            while ((line = br.readLine()) != null) {
                break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        long count = 1L * 1 * 1500;
        for(int i = 0; i < 5; i++){
            fastJsonConvert(line, count);
        }
    }



}
