package com.anzhi.solidwaste.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author anzhi
 * @date 2019/8/27 16:45
 */

@ApiModel(description= "返回响应数据")
@Data
@Accessors(chain = true)
public class AzMessage<T> implements Serializable {

    private static class AzMessageSuccess{
        private static AzMessage instance = new AzMessage(true);
    }

    private static class AzMessageFail{
        private static AzMessage instance = new AzMessage(false);
    }


    private AzMessage(){

    }

    public static AzMessage success(){
        return AzMessageSuccess.instance;
    }

    public static AzMessage fail(){
        return AzMessageFail.instance;
    }


    @ApiModelProperty(value = "是否成功")
    private boolean success = true;
    @ApiModelProperty(value = "返回对象")
    private T data;
    @ApiModelProperty(value = "返回对象列表")
    private List<T> datas;
    @ApiModelProperty(value = "错误编号")
    private Integer errCode;
    @ApiModelProperty(value = "错误信息")
    private String message;

    public AzMessage(boolean success) {
        this.success = success;
    }
}