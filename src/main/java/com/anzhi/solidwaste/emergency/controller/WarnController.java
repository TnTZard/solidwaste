package com.anzhi.solidwaste.emergency.controller;

import com.anzhi.solidwaste.common.response.*;
import com.anzhi.solidwaste.common.domain.QueryRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Api(tags = "预警管理")
@RestController
@RequestMapping("/emergency/warn")
public class WarnController {

    @PostMapping("/")
    public AzResponse add(@Validated @RequestBody Object vo){
        return null;
    }

    @GetMapping("/")
    public AzResponse get(@ApiParam(name = "id", value = "id") @RequestParam String id){
        return null;
    }

    @GetMapping("/page")
    public AzResponse page(QueryRequest queryRequest, Object vo){
        return null;
    }

    @PutMapping("/")
    public AzResponse update(@Validated @RequestBody Object vo){
        return null;
    }

    @DeleteMapping("/")
    public AzResponse delete(@ApiParam(name = "id", value = "id") @RequestParam String id){
        return null;
    }
}
