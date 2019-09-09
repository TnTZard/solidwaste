package com.anzhi.solidwaste.emergency.entity;

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
@ApiModel(value="Event对象", description="")
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "事件ID(数据库自增)")
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "事件编号")
    private String name;

    @ApiModelProperty(value = "企业名称")
    private String enterprise;

    @ApiModelProperty(value = "事件类型(分类异常0、重量异常1、污染超标2)")
    private String type;

    @ApiModelProperty(value = "事件时间")
    private LocalDateTime time;

    @ApiModelProperty(value = "事件描述")
    private String description;

    @ApiModelProperty(value = "发起人")
    private String sponsor;

    @ApiModelProperty(value = "接收人")
    private String receiver;

    @ApiModelProperty(value = "发起时间")
    private LocalDateTime gmtStart;

    @ApiModelProperty(value = "现场图片")
    private String photo;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "事件状态")
    private String status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


}
