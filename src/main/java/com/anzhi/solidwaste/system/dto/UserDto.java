package com.anzhi.solidwaste.system.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author anzhi
 * @date 2019/9/3 13:42
 */
public class UserDto {

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "角色")
    private Integer roleId;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
