package com.sly.quartz.base.interceptor;

import com.sly.quartz.base.common.Response;
import com.sly.quartz.base.common.exception.ServiceException;
import com.sly.quartz.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Created by wj on 2021/6/30 8:57
 * @Description TODO
 */
@Slf4j
@RestControllerAdvice
public class GlobalDeaultExceptionHander {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleUnProccessableException(Exception e){
        printError(e);
        return Response.error(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleUnProccessableServiceException(ServiceException e){
        return Response.error(e);
    }

    private void printError(Throwable e){
        log.error("请求意外终止，异常产生URI：{}，请留意一下堆栈信息", ServletUtils.request().getRequestURI(), e);
    }

}
