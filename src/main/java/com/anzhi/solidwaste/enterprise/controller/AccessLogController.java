package com.anzhi.solidwaste.enterprise.controller;

import com.anzhi.solidwaste.common.response.*;
import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.enterprise.entity.AccessLog;
import com.anzhi.solidwaste.enterprise.search.AccessSearch;
import com.anzhi.solidwaste.enterprise.service.AccessLogService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Api(tags = "门禁管理")
@RestController
@RequestMapping("/enterprise/access-log")
public class AccessLogController {


    @Autowired
    private AccessLogService accessLogService;


    @ApiOperation("门禁列表")
    @GetMapping("/page")
    public AzResponse page(QueryRequest queryRequest, AccessSearch accessSearch){
        IPage<AccessLog> result = this.accessLogService.listAll(queryRequest, accessSearch);
        return new AzResponse(true, result, 200, "查询成功");
    }

//    @PostMapping("/")
//    public AzResponse add(@Validated @RequestBody Object vo){
//        return null;
//    }
//
//    @GetMapping("/")
//    public AzResponse<AccessLog> get(@ApiParam(name = "id", value = "id") @RequestParam String id){
//        return null;
//    }
//
//
//
//    @PutMapping("/")
//    public AzResponse update(@Validated @RequestBody Object vo){
//        return null;
//    }
//
//    @DeleteMapping("/")
//    public AzResponse delete(@ApiParam(name = "id", value = "id") @RequestParam String id){
//        return null;
//    }


}
