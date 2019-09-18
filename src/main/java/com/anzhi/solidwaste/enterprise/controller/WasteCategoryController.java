package com.anzhi.solidwaste.enterprise.controller;

import com.anzhi.solidwaste.common.response.*;
import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.common.service.CacheService;
import com.anzhi.solidwaste.enterprise.dto.WasteCategoryDto;
import com.anzhi.solidwaste.enterprise.service.WasteCategoryService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Api(tags = "危废类别")
@RestController
@RequestMapping("/enterprise/waste-category")
public class WasteCategoryController {

    @Autowired
    private WasteCategoryService wasteCategoryService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CacheService cacheService;

    @PostMapping("/")
    public AzResponse add(@Validated @RequestBody Object vo){
        return null;
    }

    @ApiOperation(value = "获取危废类别代码")
    @GetMapping("/")
    public AzResponse get() throws Exception {
        List<WasteCategoryDto> result = this.cacheService.getWasteCategories();
        return new AzResponse(true, result, 200, "查找成功");
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
