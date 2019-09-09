package com.anzhi.solidwaste.repertory.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author anzhi
 * @date 2019/9/3 18:21
 */
@Data
public class InStorageWasteDto {


    @ApiModelProperty(value = "危废名称")
    private String wasteName;

    @ApiModelProperty(value = "危险特性")
    private String wasteFeature;

    @ApiModelProperty(value = "物理状态")
    private String physicalState;

    @ApiModelProperty(value = "转入量")
    private Double transferAmount;

    @ApiModelProperty(value = "计量单位")
    private String measurement;

    @ApiModelProperty(value = "包装方式")
    private String packing;





}
