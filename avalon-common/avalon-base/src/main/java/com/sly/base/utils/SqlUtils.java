package com.sly.base.utils;

/**
 * @Created by wj on 2021/7/20
 * @Description TODO
 */
public class SqlUtils {

    /**
     * like
     * @param likeStr
     * @return
     */
    public static String buildLikeString(String likeStr){
        return "%" + likeStr + "%";
    }

    /**
     * right like
     * @param likeStr
     * @return
     */
    public static String buildRightLikeString(String likeStr){
        return likeStr + "%";
    }


}
