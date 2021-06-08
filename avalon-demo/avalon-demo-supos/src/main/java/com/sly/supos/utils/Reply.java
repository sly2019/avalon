package com.sly.supos.utils;

import lombok.Data;

/**
 * @Author by wj on 2021/6/8 15:04
 * @Description TODO
 */
@Data
public class Reply {

    private Boolean success;
    private  Integer code;
    private String message;
    private Object data;
    private Object option;

}
