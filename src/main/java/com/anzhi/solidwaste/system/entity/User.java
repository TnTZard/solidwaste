package com.anzhi.solidwaste.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @author Anzhi
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 账户状态 0冻结 1合法
     */
    public static final Integer STATUS_VALID = 1;

    public static final Integer STATUS_LOCK = 0;

    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWORD = "anzhi";


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "账号(手机号)")
    private String account;

    @ApiModelProperty(value = "用户名(真实姓名)")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

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

    @ApiModelProperty(value = "是否启用 0：正常使用  1：冻结  2：未审核")
    private Integer isActive;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(hidden = true)
    private transient String userId;

}
