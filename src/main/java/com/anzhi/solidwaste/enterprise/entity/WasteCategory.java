package com.anzhi.solidwaste.enterprise.entity;

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
@ApiModel(value="WasteCategory对象", description="")
public class WasteCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "危废类别ID(数据库自增)")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "危废类别代码")
    private String categoryCode;

    @ApiModelProperty(value = "危废类别名")
    private String categoryName;

    @ApiModelProperty(value = "行业来源")
    private String source;

    @ApiModelProperty(value = "废物代码")
    private String wasteCode;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "危险特性")
    private String feature;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


}
