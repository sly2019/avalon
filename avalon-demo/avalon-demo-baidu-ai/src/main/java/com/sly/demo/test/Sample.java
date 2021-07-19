package com.sly.demo.test;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Created by wj on 2021/7/8 19:03
 * @Description TODO
 */
public class Sample {

    //设置APPID/AK/SK
    public static final String APP_ID = "";
    public static final String API_KEY = "";
    public static final String SECRET_KEY = "";

    public static void main(String[] args) {
        synthesis("你好！，我是百度AI智能");
    }

    public static void synthesis(String str) {
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "log4j.properties");
        // 设置可选参数
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");//语速，取值0-9，默认为5中语速      非必选
        options.put("pit", "5");//音调，取值0-9，默认为5中语调      非必选
        options.put("per", "4");//发音人选择, 0为女声，1为男声，3为情感合成-度逍遥，4为情感合成-度丫丫，默认为普通女 非必选
        TtsResponse res = client.synthesis(str, "zh", 1, options);
        JSONObject result = res.getResult();    //服务器返回的内容，合成成功时为null,失败时包含error_no等信息
        if (!StringUtils.isEmpty(result)) {
            System.out.printf("error：" + result.toString());
            return;
        }
        byte[] data = res.getData();            //生成的音频数据
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, "d://audioFile//" + UUID.randomUUID().toString() + ".mp3");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }
    }
}
