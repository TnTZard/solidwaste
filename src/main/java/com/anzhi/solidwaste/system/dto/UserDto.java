package com.anzhi.solidwaste.system.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author anzhi
 * @date 2019/9/3 13:42
 */
public class UserDto {

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "密码(默认anzhi）")
    private String password;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
