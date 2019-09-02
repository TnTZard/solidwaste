package com.anzhi.solidwaste.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author anzhi
 * @date 2019/8/27 18:26
 */
@Data
@ApiModel
@AllArgsConstructor
public class User {

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

}
