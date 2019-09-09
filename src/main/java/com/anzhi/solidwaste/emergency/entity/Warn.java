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
@ApiModel(value="Warn对象", description="")
public class Warn implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "预警ID(数据库自增)")
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "预警编号")
    private String name;

    @ApiModelProperty(value = "企业名称")
    private String enterprise;

    @ApiModelProperty(value = "行业类别")
    private String industryCategory;

    @ApiModelProperty(value = "仓库编号")
    private LocalDateTime time;

    @ApiModelProperty(value = "预警时间")
    private LocalDateTime gmtWarn;

    @ApiModelProperty(value = "预警内容")
    private String content;

    @ApiModelProperty(value = "处理状态")
    private String status;

    @ApiModelProperty(value = "处理描述及结果")
    private String description;

    @ApiModelProperty(value = "现场图片")
    private String photo;

    @ApiModelProperty(value = "处理人")
    private String person;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


}
