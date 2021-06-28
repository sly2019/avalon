package com.sly.base.common.test;

/**
 * @Author by wj on 2021/6/24 13:25
 * @Description TODO
 */
public enum  CheckType {

    SECTION("section", "区间"),
    ENUM("enum", "枚举");

    private String code;
    private String message;

    CheckType(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

}
