package com.anzhi.solidwaste.web.common;

import com.anzhi.solidwaste.common.domain.RegexpConstant;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author anzhi
 * @date 2019/9/17 9:59
 */
@Data
public class RegisterDto {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String account;

    /**
     * 密码
     */
    @Pattern(regexp = RegexpConstant.PWD_REG, message = "{密码至少包含 数字和英文，长度6-20}")
    private String password;

    /**
     * 再次输入密码
     */
    @Valid
    private String repeatPassword;

    /**
     * 环保管理0 企业1 个人2
     */
    private Integer type;

}
