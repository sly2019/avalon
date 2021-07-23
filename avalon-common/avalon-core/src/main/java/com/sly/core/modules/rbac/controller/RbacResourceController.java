package com.sly.core.modules.rbac.controller;

import com.sly.core.models.PageResponse;
import com.sly.core.models.Response;
import com.sly.core.modules.rbac.models.RbacResource;
import com.sly.core.modules.rbac.querybean.RbacResourceQueryBean;
import com.sly.core.modules.rbac.service.RbacResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Created by wj on 2021/7/19
 * @Description TODO
 */
@Slf4j
@RestController
@Api(tags = "rbac-资源")
@RequestMapping("/inter-api/rbac")
public class RbacResourceController {

    @Autowired
    private RbacResourceService rbacResourceService;

    /**
     * 分页列表
     */
    @GetMapping("/v1/rbac-resource")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "分页列表")
    public Response<PageResponse<RbacResource>> queryForList(@RequestBody RbacResourceQueryBean rbacResourceQueryBean,
            @ApiParam(value = "每页数量", example = "10") @RequestParam(value = "pageSize", required = false, defaultValue = "10") long pageSize,
            @ApiParam(value = "页数", example = "1") @RequestParam(value = "pageNo", required = false, defaultValue = "1") long pageNo) {
        return Response.ok(rbacResourceService.getPage(rbacResourceQueryBean, pageNo, pageSize));
    }

}
