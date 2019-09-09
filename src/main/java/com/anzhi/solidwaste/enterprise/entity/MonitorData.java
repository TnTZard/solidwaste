package com.anzhi.solidwaste.enterprise.entity;

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
 * @since 2019-09-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MonitorData对象", description="")
public class MonitorData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "监测数据ID(数据库自增)")
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "监测系统名")
    private String monitorName;

    @ApiModelProperty(value = "风机状态")
    private String fanStatus;

    @ApiModelProperty(value = "治理设备状态")
    private String governingStatus;

    @ApiModelProperty(value = "硫化氢浓度(ppm)")
    private String hydrogenSulfide;

    @ApiModelProperty(value = "氨浓度(mg/Nm3)")
    private String ammonia;

    @ApiModelProperty(value = "氧气浓度(mg/Nm3)")
    private String oxygen;

    @ApiModelProperty(value = "温度")
    private BigDecimal temperature;

    @ApiModelProperty(value = "湿度")
    private BigDecimal humidity;

    @ApiModelProperty(value = "压力")
    private BigDecimal pressure;

    @ApiModelProperty(value = "监测时间")
    private LocalDateTime gmtMonitor;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


}
