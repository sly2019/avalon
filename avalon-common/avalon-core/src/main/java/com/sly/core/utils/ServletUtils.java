package com.sly.core.utils;

import com.sly.core.exception.ServiceException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author by wj on 2021/7/19 16:24
 * @Description TODO
 */
public class ServletUtils {

    /**
     * 获取ServletRequestAttributes
     *
     * @return ServletRequestAttributes
     */
    public static ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    /**
     * 获取当前 request
     *
     * @return
     */
    public static HttpServletRequest request() {
        ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
        if (servletRequestAttributes == null) {
            throw new ServiceException(400,"当前非WEB环境");
        } else {
            return servletRequestAttributes.getRequest();
        }
    }

    /**
     * 获取当前 response
     *
     * @return
     */
    public static HttpServletResponse response() {
        ServletRequestAttributes servletRequestAttributes = getServletRequestAttributes();
        if (servletRequestAttributes == null) {
            throw new ServiceException(400,"当前非WEB环境");
        } else {
            return servletRequestAttributes.getResponse();
        }
    }

}