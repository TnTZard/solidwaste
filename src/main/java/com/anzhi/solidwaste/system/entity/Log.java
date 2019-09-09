package com.anzhi.solidwaste.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="Log对象", description="")
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日志ID(数据库自增)")
            @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "操作时间")
    private String time;

    @ApiModelProperty(value = "操作类型")
    private String type;

    @ApiModelProperty(value = "IP地址")
        @TableField("IP")
    private String ip;

    @ApiModelProperty(value = "操作用户")
    private String user;

    @ApiModelProperty(value = "操作状态")
    private String status;

    @ApiModelProperty(value = "操作描述")
    private String description;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


}
