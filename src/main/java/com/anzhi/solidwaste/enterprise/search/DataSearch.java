package com.anzhi.solidwaste.enterprise.search;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anzhi
 * @date 2019/9/4 14:56
 */
@Data
public class DataSearch {

    @ApiModelProperty(value = "仓库编号")
    private String depotName;

    @ApiModelProperty(value = "单位名称")
    private String enterpriseName;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;
}
