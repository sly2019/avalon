package com.sly.core.exception;

import com.sly.core.models.Response;
import lombok.Getter;

/**
 * @Created by wj on 2021/7/19
 * @Description 服务异常
 */
@Getter
public class ServiceException extends RuntimeException{

    private int code = Response.DEFAULT_ERROR_CODE;
    private String message = Response.DEFAULT_ERROR_MSG;

    public ServiceException() {
    }

    public ServiceException(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
