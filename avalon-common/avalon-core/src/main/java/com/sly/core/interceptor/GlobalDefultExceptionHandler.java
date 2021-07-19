package com.sly.core.interceptor;

import com.sly.core.exception.ServiceException;
import com.sly.core.models.Response;
import com.sly.core.utils.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author by wj on 2021/7/19 16:24
 * @Description 统一拦截异常
 */
@Slf4j
@RestControllerAdvice
public class GlobalDefultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleUnProccessableException(Exception e) {
        //系统出现意外情况的错误
        printError(e);
        return Response.error(HttpStatus.BAD_REQUEST.value(),e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleUnProcessableHandleException(ServiceException e){
        return  Response.error(e);
    }

    /**
     * 系统出现意外情况的错误时整理打印错误信息
     *
     * @param e
     */
    private void printError(Throwable e) {
        log.error("请求意外终止，异常产生URI:{}，请留意以下堆栈信息", ServletUtils.request().getRequestURI(), e);

    }

}