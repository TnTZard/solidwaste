package com.anzhi.solidwaste.enterprise.entity;

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
 * @since 2019-09-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="MonitorSystem对象", description="")
public class MonitorSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "监测系统ID(数据库自增)")
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "监测系统名")
    private String monitorName;

    @ApiModelProperty(value = "仓库编号")
    private String depotId;

    @ApiModelProperty(value = "危废类别代码")
    private String wasteCode;

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

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


}
