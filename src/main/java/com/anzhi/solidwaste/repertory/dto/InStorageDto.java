package com.anzhi.solidwaste.repertory.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author anzhi
 * @date 2019/9/3 18:29
 */
@Data
public class InStorageDto {


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

    @ApiModelProperty(value = "经办人")
    private String dealPerson;

    @ApiModelProperty(value = "危废列表")
    private List<InStorageWasteDto> inStorageWasteDtoList;

}
