package com.sly.core.modules.sys.controller;

import com.sly.core.models.PageResponse;
import com.sly.core.models.Response;
import com.sly.core.modules.rbac.models.RbacResource;
import com.sly.core.modules.rbac.querybean.RbacResourceQueryBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Created by wj on 2021/8/5
 * @Description TODO
 */
@Slf4j
@RestController
@Api(tags = "sys-test")
@RequestMapping("/inter-api/test")
public class TestController {

    /**
     * 分页列表
     */
    @GetMapping("/v1/rbac-resource")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "分页列表")
    public Response<PageResponse<RbacResource>> queryForList(@RequestBody RbacResourceQueryBean rbacResourceQueryBean,
                                                             @ApiParam(value = "每页数量", example = "10") @RequestParam(value = "pageSize", required = false, defaultValue = "10") long pageSize,
                                                             @ApiParam(value = "页数", example = "1") @RequestParam(value = "pageNo", required = false, defaultValue = "1") long pageNo) {
        return Response.ok();
    }

}
