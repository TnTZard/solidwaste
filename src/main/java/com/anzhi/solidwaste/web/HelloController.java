package com.anzhi.solidwaste.web;

import com.alibaba.fastjson.JSONObject;
import com.anzhi.solidwaste.common.domain.UploadObject;
import com.anzhi.solidwaste.common.exception.AzException;
import com.anzhi.solidwaste.common.response.AzMessage;
import com.anzhi.solidwaste.common.response.AzResponse;
import com.anzhi.solidwaste.common.service.UploadService;
import com.anzhi.solidwaste.system.entity.File;
import com.anzhi.solidwaste.system.entity.User;
import io.swagger.annotations.*;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author anzhi
 * @date 2019/8/27 17:46
 */
@Api(tags = "测试接口")
@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private UploadService uploadService;

    @GetMapping
    public AzMessage list() {


        return null;
        //return AzMessage.getSuccessMsg().setData("hello").setData("hello2");
    }



    @ApiOperation("测试文件上传")
    @PostMapping("/file")
    public AzResponse add(@RequestParam("files") MultipartFile[] files) throws AzException {
        try {
            UploadObject uploadObject = new UploadObject(files);
            this.uploadService.uploadFile(uploadObject);
            List<FileResponse> fileResponses = new ArrayList<>();
            uploadObject.getFileInfo().forEach((name, path) -> {
                FileResponse fileResponse = new FileResponse();
                fileResponse.setOriginalName(name);
                fileResponse.setPath(path);
                fileResponses.add(fileResponse);
            });
            return new AzResponse(true,fileResponses, 200, "上传成功");
        } catch (Exception e) {
            throw new AzException(e.getMessage());
        }
    }


    @GetMapping("/getJson")
    @ApiOperation("响应JSONObject类型")
    @ApiOperationSupport( responses = @DynamicResponseParameters(properties = {
            @DynamicParameter(value = "编号", name = "id"),
            @DynamicParameter(value = "名称", name = "name"),
            @DynamicParameter(value = "订单", name = "orderDate", dataTypeClass = AzMessage.class)
    }))
    public JSONObject getJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "xx");
        return jsonObject;
    }


    @GetMapping("/getMap")
    @ApiOperation("响应Map类型")
    @ApiOperationSupport( responses = @DynamicResponseParameters(properties = {
            @DynamicParameter(value = "状态", name ="message"),
            @DynamicParameter(value = "消息", name ="info"),
            @DynamicParameter(value = "用户信息", name ="data", dataTypeClass = User.class)
    }))
    public AzResponse getMap() {
        return null;
        //return new AzResponse().success("xiaoxi").data(new User("xxx", "123"));
    }
}


class FileResponse{
    private String originalName;
    private String path;

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}