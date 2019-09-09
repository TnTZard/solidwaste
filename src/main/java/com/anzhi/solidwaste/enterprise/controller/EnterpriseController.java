package com.anzhi.solidwaste.enterprise.controller;

import com.anzhi.solidwaste.common.domain.UploadObject;
import com.anzhi.solidwaste.common.exception.AzException;
import com.anzhi.solidwaste.common.response.*;
import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.common.service.UploadService;
import com.anzhi.solidwaste.enterprise.entity.Enterprise;
import com.anzhi.solidwaste.enterprise.service.EnterpriseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiOperationSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Api(tags = "企业管理")
@RestController
@RequestMapping("/enterprise/enterprise")
public class EnterpriseController {


    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private UploadService uploadService;

    @ApiOperation("新增企业")
    @PostMapping("/")
    public AzResponse add(@Validated @RequestBody Enterprise enterprise,  @RequestParam("files") MultipartFile[] multipartFiles) throws AzException {
        try {
            UploadObject uploadObject = new UploadObject(multipartFiles);
            this.uploadService.uploadFile(uploadObject);
            this.enterpriseService.createEnterprise(enterprise, uploadObject);
            return new AzResponse(true, null, 200, "新增成功");
        } catch (Exception e) {
            throw new AzException(e.getMessage());
        }

    }

    @ApiOperation("获取单个企业信息")
    @GetMapping("/")
    public AzResponse get(@ApiParam(name = "id", value = "id") @RequestParam String id) {
        return null;
    }

    @ApiOperation("获取企业列表")
    @GetMapping("/page")
    public AzResponse page(QueryRequest queryRequest, Object vo) {
        return null;
    }

    @ApiOperation("更新企业")
    @PutMapping("/")
    public AzResponse update(@Validated @RequestBody Object vo) {
        return null;
    }

    @ApiOperation("删除企业")
    @DeleteMapping("/")
    public AzResponse delete(@ApiParam(name = "id", value = "id") @RequestParam String id) {
        return null;
    }


}
