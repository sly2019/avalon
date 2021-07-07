package com.sly.quartz.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author by wj on 2021/7/5 14:12
 * @Description TODO
 */
public class TestController {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "中国";
        System.out.println(URLEncoder.encode(str, "utf-8"));
    }
}
