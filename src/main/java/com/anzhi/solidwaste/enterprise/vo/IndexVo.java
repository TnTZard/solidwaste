package com.anzhi.solidwaste.enterprise.vo;

import com.anzhi.solidwaste.enterprise.entity.Enterprise;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author anzhi
 * @date 2019/9/9 15:25
 */
@Data
public class IndexVo {

    @ApiModelProperty(value = "企业列表")
    private List<EnterpriseVo> enterpriseList;

    @ApiModelProperty(value = "企业数量")
    private Integer enterpriseCount;

    @ApiModelProperty(value = "仓库数量")
    private Integer depotCount;

    @ApiModelProperty(value = "危险废物种类")
    private Integer wasteCategoryCount;

    @ApiModelProperty(value = "危险废物总量")
    private Integer wasteAmount;

    @ApiModelProperty(value = "异常事件数量")
    private Integer abnormalEvent;

}
