package com.anzhi.solidwaste.sys.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author anzhi
 * @date 2019/8/29 16:29
 */
@Data
@AllArgsConstructor
public class Role {

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "角色名")
    private String name;


}
