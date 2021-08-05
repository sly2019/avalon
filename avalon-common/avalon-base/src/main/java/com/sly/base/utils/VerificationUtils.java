package com.sly.base.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Created by wj on 2021/8/3
 * @Description 校验
 */
public class VerificationUtils {

    /**
     * 是否包含特殊字符，允许下划线_
     * @param str
     * @return
     */
    public static boolean specialCharCheck(String str){
        String regEx = "[ `~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 身份证号码是否合法
     * @param idCard
     * @return
     */
    public static boolean idCardCheck(String idCard){
        return false;
    }

    public static void main(String[] args) {
        Boolean b1 = null;
        Boolean b2 = true;
        Boolean b3 = false;
        if(b1 != null  && b1){
            System.out.println("b1");
        }
        if(b2){
            System.out.println("b2");
        }
        if(b3){
            System.out.println("b3");
        }

        if(!(b1 != null  && b1)){
            System.out.println("!b1");
        }
        if(!b2){
            System.out.println("!b2");
        }
        if(!b3){
            System.out.println("!b3");
        }

    }

}
