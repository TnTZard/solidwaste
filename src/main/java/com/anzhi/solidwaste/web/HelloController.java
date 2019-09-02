package com.anzhi.solidwaste.web;

import com.alibaba.fastjson.JSONObject;
import com.anzhi.solidwaste.common.response.AzMessage;
import com.anzhi.solidwaste.common.response.AzResponse;
import io.swagger.annotations.*;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author anzhi
 * @date 2019/8/27 17:46
 */
@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public AzMessage list() {


        return null;
        //return AzMessage.getSuccessMsg().setData("hello").setData("hello2");
    }

    @PostMapping
    public AzMessage add() {


        return null;
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
