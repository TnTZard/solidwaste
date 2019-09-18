package com.anzhi.solidwaste.enterprise.vo;

import com.anzhi.solidwaste.enterprise.entity.WasteCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author anzhi
 * @date 2019/9/9 17:01
 */
@Data
public class EnterpriseVo {

    /**
     *  单位名称
     */
    @ApiModelProperty(value = "单位名称")
    private String enterpriseName;

    /**
     *  企业地址
     */
    @ApiModelProperty(value = "企业地址")
    private String address;

    /**
     * 危废存量
     */
    @ApiModelProperty(value = "危废存量")
    private Double wasteStock;

    /**
     * 环境状况
     */
    @ApiModelProperty(value = "环境状况")
    private String environmentalCondition;


}
