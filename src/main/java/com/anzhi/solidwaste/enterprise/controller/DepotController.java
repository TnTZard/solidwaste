package com.anzhi.solidwaste.enterprise.controller;

import com.anzhi.solidwaste.common.domain.UploadObject;
import com.anzhi.solidwaste.common.exception.AzException;
import com.anzhi.solidwaste.common.response.*;
import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.common.service.UploadService;
import com.anzhi.solidwaste.enterprise.mapper.DepotMapper;
import com.anzhi.solidwaste.enterprise.service.DepotService;
import com.anzhi.solidwaste.repertory.dto.InStorageDto;
import com.anzhi.solidwaste.repertory.entity.InStorage;
import com.anzhi.solidwaste.repertory.entity.OutStorage;
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
@Api(tags = "仓库管理")
@RestController
@RequestMapping("/enterprise/depot")
public class DepotController {

    @Autowired
    private DepotService depotService;
    @Autowired
    private UploadService uploadService;

    @ApiOperation("新增仓库")
    @PostMapping("/")
    public AzResponse add(@Validated @RequestBody Object vo){
        return null;
    }

    @ApiOperation("获得单个仓库信息")
    @GetMapping("/")
    public AzResponse get(@ApiParam(name = "id", value = "id") @RequestParam String id){
        return null;
    }

    @ApiOperation("获得仓库列表")
    @GetMapping("/page")
    public AzResponse page(QueryRequest queryRequest, Object vo){
        return null;
    }

    @ApiOperation("更新仓库（暂无）")
    @PutMapping("/")
    public AzResponse update(@Validated @RequestBody Object vo){
        return null;
    }

    @ApiOperation("删除仓库（暂无）")
    @DeleteMapping("/")
    public AzResponse delete(@ApiParam(name = "id", value = "id") @RequestParam String id){
        return null;
    }



    @ApiOperation("入库")
    @PostMapping("/in-Storage")
    public AzResponse inStorage(@RequestBody InStorageDto inStorageDto) throws AzException {
        try{
            // 入库操作
            this.depotService.inStorage(inStorageDto);
            return new AzResponse(true,null,null,"入库成功");
        } catch (Exception e) {
            throw new AzException(e.getMessage());
        }
    }


    @ApiOperation("出库")
    @ApiOperationSupport(ignoreParameters = {"id","transferOrder"})
    @PostMapping("/out-Storage")
    public AzResponse outStorage(OutStorage outStorage, @RequestParam("files") MultipartFile[] multipartFiles) throws IOException {
        UploadObject uploadObject = new UploadObject(multipartFiles);
        this.uploadService.uploadFile(uploadObject);
        this.depotService.outStorage(outStorage);
        return new AzResponse();
    }
}
