package com.anzhi.solidwaste.enterprise.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anzhi
 * @date 2019/9/3 22:10
 */
@Data
public class MonitorSystemVo {

    @ApiModelProperty(value = "仓库编号")
    private String depotId;

    @ApiModelProperty(value = "风机状态")
    private String fanStatus;

    @ApiModelProperty(value = "治理设备状态")
    private String governingStatus;

    @ApiModelProperty(value = "硫化氢浓度(ppm)")
    private String hydrogenSulfide;

    @ApiModelProperty(value = "氨浓度(mg/Nm3)")
    private String ammonia;

    @ApiModelProperty(value = "氧气浓度(mg/Nm3")
    private String oxygen;

}
