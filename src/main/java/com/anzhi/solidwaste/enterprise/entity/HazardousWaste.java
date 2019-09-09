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
@ApiModel(value="HazardousWaste对象", description="")
public class HazardousWaste implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "危废ID(数据库自增)")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "仓库编号")
    private String depotId;

    @ApiModelProperty(value = "危废名称")
    private String name;

    @ApiModelProperty(value = "危废特性")
    private String feature;

    @ApiModelProperty(value = "物理状态")
    private String physicalState;

    @ApiModelProperty(value = "包装方式")
    private String packing;

    @ApiModelProperty(value = "转入量")
    private Double transferAmount;

    @ApiModelProperty(value = "现存量")
    private Double existAmount;

    @ApiModelProperty(value = "危险类别")
    private String wasteCategory;

    @ApiModelProperty(value = "危险代码(类别的代码）")
    private String wasteCode;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;

    @ApiModelProperty(value = "批次编号")
    private String batchNumber;

    @ApiModelProperty(value = "计量单位")
    private String measurement;

}
