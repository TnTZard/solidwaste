package com.anzhi.solidwaste.enterprise.search;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anzhi
 * @date 2019/9/3 21:39
 */
@Data
public class AccessSearch {

    @ApiModelProperty(value = "企业名")
    private String enterpriseName;

    @ApiModelProperty(value = "员工姓名")
    private String person;

    @ApiModelProperty(value = "开始时间")
    private String startTime;

    @ApiModelProperty(value = "结束时间")
    private String endTime;

}
