package com.anzhi.solidwaste.sys.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * @author anzhi
 * @date 2019/8/29 16:27
 */
@Data
@Accessors(chain = true)
public class User {

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "角色列表")
    private List<Role> roles;

    @ApiModelProperty(value = "map")
    private Map<String, String> map;

}
