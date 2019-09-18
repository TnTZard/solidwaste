package com.anzhi.solidwaste.web.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anzhi
 * @date 2019/9/18 14:44
 */
@Data
public class NormalUserDto extends RegisterDto {

    @ApiModelProperty(value = "真实姓名")
    private String username;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "性别 0男 1女")
    private String gender;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "手机")
    private String telephone;

    @ApiModelProperty(value = "座机")
    private String fixedLine;

    @ApiModelProperty(value = "住址")
    private String address;

    @ApiModelProperty(value = "毕业院校")
    private String school;

    @ApiModelProperty(value = "专业")
    private String profession;

    @ApiModelProperty(value = "职务")
    private String position;

    @ApiModelProperty(value = "所属单位")
    private String company;

    @ApiModelProperty(value = "身份证")
    private String identity;

    @ApiModelProperty(value = "身份证正面")
    private String idCardFront;

    @ApiModelProperty(value = "身份证反面")
    private String idCardBack;




}
