package com.sly.base.utils;

import java.util.UUID;

/**
 * @Created by wj on 2021/7/19
 * @Description TODO
 */
public class Generator {

    /**
     * 生成uuid
     * @return
     */
    public static String genUUID(){
        return  UUID.randomUUID().toString().replace("-","");
    }
}
