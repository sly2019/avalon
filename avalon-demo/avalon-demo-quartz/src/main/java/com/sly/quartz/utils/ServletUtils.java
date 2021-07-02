package com.sly.quartz.utils;

import com.sly.quartz.base.common.exception.ServiceException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author by wj on 2021/6/30 9:01
 * @Description TODO
 */
public class ServletUtils {

    public static ServletRequestAttributes getServletRequestAttributes(){
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 获取当前request
     * @return
     */
    public static HttpServletRequest request(){
        ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
        if(servletRequestAttributes == null){
            throw new ServiceException(409, "当前非web环境");
        } else {
            return servletRequestAttributes.getRequest();
        }
    }

    public static HttpServletResponse response(){
        ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
        if(servletRequestAttributes == null){
            throw new ServiceException(409, "当前非web环境");
        } else {
            return servletRequestAttributes.getResponse();
        }
    }


}
