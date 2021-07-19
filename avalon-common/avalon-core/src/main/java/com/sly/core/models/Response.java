package com.sly.core.models;

import com.sly.core.exception.ServiceException;
import com.sly.core.utils.ServletUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author by wj on 2021/7/19 16:30
 * @Description TODO
 */
@Data
@ApiModel
public class Response<T> {

    public static final int DEFAULT_OK_CODE = 200;
    public static final String DEFAULT_OK_MSG = "success";
    public static final int DEFAULT_ERROR_CODE = 500;
    public static final String DEFAULT_ERROR_MSG = "服务器异常，请稍后再试";

    @ApiModelProperty(value = "状态码", required = true, example = "200")
    private int code = 200;
    @ApiModelProperty(value = "消息", required = true, example = "success")
    private String message;
    @ApiModelProperty(value = "资源地址", required = true, example = "/api/...")
    private String path;

    private T data;

    public static Response ok() {
        Response result = new Response();
        result.code = DEFAULT_OK_CODE;
        result.message = DEFAULT_OK_MSG;
        result.path = ServletUtils.request().getRequestURI();

        return result;
    }

    public static <T> Response<T> ok(T data) {
        Response<T> result = new Response<>();
        result.code = DEFAULT_OK_CODE;
        result.message = DEFAULT_OK_MSG;
        result.path = ServletUtils.request().getRequestURI();
        result.data = data;
        return result;
    }


    public static Response error() {
        Response result = new Response();
        result.code = DEFAULT_ERROR_CODE;
        result.message = DEFAULT_ERROR_MSG;
        result.path = ServletUtils.request().getRequestURI();

        return result;
    }

    public static Response error(int code, String message) {
        Response result = new Response();
        result.code = code;
        result.message = message;
        result.path = ServletUtils.request().getRequestURI();
        return result;
    }

    public static Response error(ServiceException e) {
        Response result = new Response();
        result.code = e.getCode();
        result.message = e.getMessage();
        result.path = ServletUtils.request().getRequestURI();

        return result;
    }

    public static Response error(Throwable throwable) {
        Response result = new Response();
        result.code = DEFAULT_ERROR_CODE;
        result.message = throwable.getMessage();
        result.path = ServletUtils.request().getRequestURI();

        return result;
    }
}
