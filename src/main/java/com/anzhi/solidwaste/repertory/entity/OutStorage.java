package com.anzhi.solidwaste.repertory.entity;

import java.math.BigDecimal;
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
@ApiModel(value="OutStorage对象", description="")
public class OutStorage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出库ID(数据库自增)")
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "出库编号")
    private String name;

    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "行业类别")
    private String industryCategory;

    @ApiModelProperty(value = "仓库编号")
    private String depotId;

    @ApiModelProperty(value = "危废类别")
    private String wasteCategory;

    @ApiModelProperty(value = "危废代码")
    private String wasteCode;

    @ApiModelProperty(value = "危废名称")
    private String wasteName;

    @ApiModelProperty(value = "危险特性")
    private String wasteFeature;

    @ApiModelProperty(value = "物理状态")
    private String physicalState;

    @ApiModelProperty(value = "转出量(kg)")
    private BigDecimal transferAmount;

    @ApiModelProperty(value = "包装方式")
    private String packing;

    @ApiModelProperty(value = "出库时间")
    private LocalDateTime gmtStorage;

    @ApiModelProperty(value = "经办人")
    private String dealPerson;

    @ApiModelProperty(value = "转移联单(文件)")
    private String transferOrder;

    @ApiModelProperty(value = "接收单位名称")
    private String receiveName;

    @ApiModelProperty(value = "联系人")
    private String contactPerson;

    @ApiModelProperty(value = "联系方式")
    private String contactPhone;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


}
