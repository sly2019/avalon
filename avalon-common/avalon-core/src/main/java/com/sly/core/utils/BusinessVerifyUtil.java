package com.sly.core.utils;

import com.sly.core.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 业务校验
 */
public class BusinessVerifyUtil {

    /**
     * 私有构造期
     */
    private BusinessVerifyUtil(){}

    /**
     * 空校验
     * @param o
     */
    public static void nullVerify(Object o){
        if(o == null){
            throw new ServiceException(409, "数据为空");
        }
    }

    /**
     * 空校验
     * @param o
     */
    public static void nullVerify(Object o, int code, String message){
        if(o == null){
            throw new ServiceException(code, message);
        }
    }

    /**
     * 字符为空校验
     * @param value
     */
    public static void emptyVerify(String value){
        if(StringUtils.isEmpty(value)){
            throw new ServiceException(409, "输入信息为空");
        }
    }

    /**
     * 字符为空校验
     * @param value 校验项
     * @param code 返回码
     * @param message 返回信息
     */
    public static void emptyVerify(String value, int code, String message){
        if(StringUtils.isEmpty(value)){
            throw new ServiceException(code, message);
        }
    }

    /**
     * 数组为空校验
     * @param values 校验项
     */
    public static void emptyVerify(Object[] values){
        if(values == null || values.length == 0){
            throw new ServiceException(409, "数组为空");
        }
    }

    /**
     * 数组为空校验
     * @param values 校验项
     * @param code 返回码
     * @param message 返回信息
     */
    public static void emptyVerify(Object[] values, int code, String message){
        if(values == null || values.length == 0){
            throw new ServiceException(code, message);
        }
    }

    /**
     * 字符为空校验,包括全为制表符、换行符、换页符和回车符等的情况
     * @param value 校验项
     */
    public static void blankVerify(String value){
        if(StringUtils.isBlank(value)){
            throw new ServiceException(409, "输入信息为空");
        }
    }

    /**
     * 字符为空校验,包括全为制表符、换行符、换页符和回车符等的情况
     * @param value 校验项
     * @param code 返回码
     * @param message 返回信息
     */
    public static void blankVerify(String value, int code, String message){
        if(StringUtils.isBlank(value)){
            throw new ServiceException(code, message);
        }
    }

    /**
     * 字符长度超过限制校验
     * @param value 校验项
     * @param len 字符限制长度
     */
    public static void tooLongVerify(String value, long len){
        if(StringUtils.isNotEmpty(value) && value.length() > len){
            throw new ServiceException(409, "输入信息长度超过" + len);
        }
    }

    /**
     * 字符长度超过限制校验
     * @param value 校验项
     * @param len 字符限制长度
     * @param code 返回码
     * @param message 返回信息
     */
    public static void tooLongVerify(String value, long len, int code, String message){
        if(StringUtils.isNotEmpty(value) && value.length() > len){
            throw new ServiceException(code, message);
        }
    }

    /**
     * 数组大小超过限制校验
     * @param values 校验项
     * @param size 数组限制长度
     */
    public static void tooLongVerify(Object[] values, long size){
        if(values != null && values.length > size){
            throw new ServiceException(409, "数组大小超过" + size);
        }
    }

    /**
     * 数组大小超过限制校验
     * @param values 校验项
     * @param size 数组限制长度
     * @param code 返回码
     * @param message 返回信息
     */
    public static void tooLongVerify(Object[] values, long size, int code, String message){
        if(values != null && values.length > size){
            throw new ServiceException(code, message);
        }
    }

    /**
     * ip地址校验
     * @param ip
     */
    public static void ipVerify(String ip) {
        if(StringUtils.isEmpty(ip)){
            throw new ServiceException(409, "IP地址信息为空");
        }
        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
        if (!ip.matches(regex)) {
            throw new ServiceException(409, "IP地址不合法");
        }
    }

    /**
     * 端口号校验
     * @param port 端口号
     */
    public static void portVerify(int port){
        if(port < 1 || port > 65535){
            throw new ServiceException(409, "端口号不正确");
        }
    }

    /**
     * 端口号校验
     * @param port
     */
    public static void portVerify(String port){
        if(StringUtils.isEmpty(port)){
            throw new ServiceException(409, "端口号为空");
        }
        String regex = "([1-9]|[1-9]\\d|[1-9]\\d{2}|[1-9]\\d{3}|[1-5]\\d{4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5])";
        if (!port.matches(regex)) {
            throw new ServiceException(409, "端口号不正确");
        }
    }

    /**
     * 手机号校验
     * 因为各运营商号段比较复杂，且随时会更新，因此此处为弱验证，只验证首位为1的11位数字
     * @param phone
     */
    public static void phoneVerify(String phone){
        if (StringUtils.isEmpty(phone) || 11 != phone.length()) {
            throw new ServiceException(409, "手机号长度不正确");
        }
        String regex = "^1\\d{10}";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(phone);
        boolean isMatch = match.matches();
        if (!isMatch) {
            throw new ServiceException(409, "手机号格式不正确");
        }
    }

    /**
     * 身份证号码校验
     * @param idcard
     */
    public static void idcardVerify(String idcard){
        if(!IdcardValidatorUtil.isValidatedAllIdcard(idcard)){
            throw new ServiceException(409, "身份证号码不合法");
        }
    }

    /**
     * rtsp地址验证
     * rtsp://username:password@ip[:port]/*
     * @param rtsp
     */
    public static void rtspVerify(String rtsp){
        if(StringUtils.isEmpty(rtsp)){
            throw new ServiceException(409, "rtsp地址为空");
        }
        String regex = "^rtsp://.+:.+@";
        regex += "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)";
        regex += "(:([1-9]|[1-9]\\d|[1-9]\\d{2}|[1-9]\\d{3}|[1-5]\\d{4}|6[0-4]\\d{3}|65[0-4]\\d{2}|655[0-2]\\d|6553[0-5]))?/.+";
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(rtsp);
        boolean isMatch = match.matches();
        if (!isMatch) {
            throw new ServiceException(409, "rtsp地址格式不正确");
        }
    }

    /**
     * 重复项校验
     * @param es
     * @param code
     * @param message
     */
    public static void repeatElementVerify(String[] es, int code, String message){
        if(es == null || es.length == 0){
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        for(String e : es){
            if(map.containsKey(e)){
                throw new ServiceException(code, message);
            }
            map.put(e, 1);
        }
    }

    /**
     * 重复项校验
     * @param es
     * @param code
     * @param message
     */
    public static void repeatElementVerify(List<String> es, int code, String message){
        if(es == null || es.size() == 0){
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        for(String e : es){
            if(map.containsKey(e)){
                throw new ServiceException(code, message);
            }
            map.put(e, 1);
        }
    }

    public static void main(String[] args) {
        String rtsp= "rtsp://admin:123456@10.10.109.10:554/main/h264";
        rtspVerify(rtsp);
    }

}
