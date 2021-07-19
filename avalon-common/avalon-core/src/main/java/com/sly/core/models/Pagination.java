package com.sly.core.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class Pagination implements Serializable {

    @ApiModelProperty(value = "页数", example = "1")
    private int pageNo = 1;

    @ApiModelProperty(value = "每页数量", example = "10")
    private int pageSize = 10;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageIndex) {
        //服务端，页索引是从0开始的，所以要减一
        this.pageNo = pageIndex - 1;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


}
