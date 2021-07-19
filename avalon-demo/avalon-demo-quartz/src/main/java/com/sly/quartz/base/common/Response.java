package com.sly.quartz.base.common;

import com.alibaba.fastjson.JSON;
import com.sly.quartz.base.common.exception.ServiceException;
import com.sly.quartz.utils.ServletUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Created by wj on 2021/7/1
 * @Description TODO
 */
@Data
@ApiModel
public class Response<T> {

    public static final int DEFAULT_OK_CODE = 200;
    public static final String DEFAULT_OK_MESSAGE = "success";

    public static final int DEFAULT_ERROR_CODE = 500;
    public static final String DEFAULT_ERROR_MESSAGE = "服务异常，请稍后再试";

    @ApiModelProperty(value = "状态码", required = true, example = "200")
    private int code = 200;

    @ApiModelProperty(value = "消息", required = true, example = "success")
    private String message;

    @ApiModelProperty(value = "资源地址", required = true, example = "/api/...")
    private String path;

    private T data;

    public static Response ok(){
        Response res = new Response();
        res.code = DEFAULT_OK_CODE;
        res.message = DEFAULT_OK_MESSAGE;
        res.path = ServletUtils.request().getRequestURI();
        return res;
    }

    private static <T> Response<T> ok(T data){
        Response<T> res = new Response<T>();
        res.code = DEFAULT_OK_CODE;
        res.message = DEFAULT_OK_MESSAGE;
        res.path = ServletUtils.request().getRequestURI();
        res.data = data;
        return res;
    }

    public static Response error(){
        Response res = new Response();
        res.code = DEFAULT_ERROR_CODE;
        res.message = DEFAULT_ERROR_MESSAGE;
        res.path = ServletUtils.request().getRequestURI();
        return res;
    }

    public static Response error(int code, String mmessage){
        Response res = new Response();
        res.code = code;
        res.message = mmessage;
        res.path = ServletUtils.request().getRequestURI();
        return res;
    }

    public static Response error(ServiceException se){
        Response res = new Response();
        res.code = se.getCode();
        res.message = se.getMessage();
        res.path = ServletUtils.request().getRequestURI();
        return res;
    }

    public static Response error(Throwable t){
        Response res = new Response();
        res.code = DEFAULT_ERROR_CODE;
        res.message = t.getMessage();
        res.path = ServletUtils.request().getRequestURI();
        return res;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

}
