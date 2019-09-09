package com.anzhi.solidwaste.enterprise.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

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
@ApiModel(value="Enterprise对象", description="")
public class Enterprise implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "企业ID(数据库自增)")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String name;

    @ApiModelProperty(value = "行业类别")
    private String industryCategory;

    @ApiModelProperty(value = "法人代表")
    private String legalRepresentative;

    @ApiModelProperty(value = "注册地址")
    private String registeredAddress;

    @ApiModelProperty(value = "营业执照(图片文件)")
    private String businessLicense;

    @ApiModelProperty(value = "企业规模")
    private String businessScale;

    @ApiModelProperty(value = "注册资金")
    private String registeredCapital;

    @ApiModelProperty(value = "行业类别代码")
    private String industryCategoryCode;

    @ApiModelProperty(value = "危废类别")
    private String wasteCategory;

    @ApiModelProperty(value = "危废名称")
    private String wasteName;

    @ApiModelProperty(value = "危废代码")
    private String wasteCode;

    @ApiModelProperty(value = "危废预计年产生量")
    private BigDecimal wasteProduction;

    @ApiModelProperty(value = "危废特性")
    private String wasteFeature;

    @ApiModelProperty(value = "仓库位置")
    private String depotPosition;

    @ApiModelProperty(value = "仓库数量")
    private String depotNum;

    @ApiModelProperty(value = "环保负责人")
    private String environmentPerson;

    @ApiModelProperty(value = "核准经营方式 0收集 1贮存 2处理")
    private String approvedMode;

    @ApiModelProperty(value = "应急联系人")
    private String emergencyContact;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;

    /**
     * 仓库列表
     */
    @TableField(exist = false)
    private List<Depot> depotList ;
}
