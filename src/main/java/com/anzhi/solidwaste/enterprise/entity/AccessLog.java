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
@ApiModel(value="AccessLog对象", description="")
public class AccessLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "门禁日志ID(数据库自增)")
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "企业名称")
    private String enterprise;

    @ApiModelProperty(value = "仓库编号")
    private String depotId;

    @ApiModelProperty(value = "姓名")
    private String person;

    @ApiModelProperty(value = "进入时间")
    private LocalDateTime gmtEnter;


}
