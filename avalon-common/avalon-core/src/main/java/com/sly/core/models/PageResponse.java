package com.sly.core.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * @Author by wj on 2021/7/19 16:24
 * @Description TODO
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class PageResponse<T> {

    /**
     * 查询数据列表
     */
    @ApiModelProperty(value = "数据列表", required = true)
    protected List<T> list = Collections.emptyList();

    /**
     * 每页显示条数
     */
    @ApiModelProperty(value = "每页条数", required = true, example = "10")
    private long pageSize;
    /**
     * 当前页 1开始
     */
    @ApiModelProperty(value = "页索引", required = true, example = "1")
    private long current;
    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数", required = true, example = "10")
    private long pageTotal;
    /**
     * 总数据条数
     */
    @ApiModelProperty(value = "总条数", required = true, example = "99")
    private long countTotal;

    public PageResponse(long current, long pageSize, long countTotal) {
        //页码转换到前端，由1开始
        this.current = current == 0 ? 1 : current;
        this.pageSize = pageSize;
        this.countTotal = countTotal;
        this.pageTotal = (int) (countTotal % pageSize == 0 ? countTotal / pageSize : countTotal / pageSize + 1);
    }
}
