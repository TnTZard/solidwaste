package com.anzhi.solidwaste.common.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author andy
 * @date 2019/6/30 20:56
 */
public class AzResponse<T> {

    @ApiModelProperty(value = "是否成功")
    private boolean success = true;

    @ApiModelProperty(value = "返回对象（数据）")
    private T data;

    @ApiModelProperty(value = "响应编号")
    private Integer errCode;

    @ApiModelProperty(value = "响应信息")
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AzResponse(boolean success, T data, Integer errCode, String message) {
        this.success = success;
        this.data = data;
        this.errCode = errCode;
        this.message = message;
    }

    public AzResponse() {

    }
}
