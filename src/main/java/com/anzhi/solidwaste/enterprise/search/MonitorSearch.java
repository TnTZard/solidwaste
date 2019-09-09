package com.anzhi.solidwaste.enterprise.search;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anzhi
 * @date 2019/9/3 15:51
 */
@Data
public class MonitorSearch {

    @ApiModelProperty(value = "仓库编号")
    private String depotName;

    @ApiModelProperty(value = "单位名称")
    private String enterpriseName;

}
