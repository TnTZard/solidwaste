package com.anzhi.solidwaste.enterprise.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author anzhi
 * @date 2019/9/3 22:08
 */

@Data
public class MonitorRealTimeVo {

    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "行业类别")
    private String industryCategory;

    @ApiModelProperty(value = "监测系统列表")
    private List<MonitorSystemVo> monitorSystemVoList;
}
