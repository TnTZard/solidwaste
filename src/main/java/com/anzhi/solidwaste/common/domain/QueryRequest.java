package com.anzhi.solidwaste.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author andy
 * @date 2019/6/30 19:36
 */
@ApiModel
@Data
public class QueryRequest implements Serializable {


    @ApiModelProperty(value="一页显示多少数据", example = "10", position = 0)
    private int pageSize = 10;

    @ApiModelProperty(value="第几页", example = "1", position = 1)
    private int pageNum = 1;


    @ApiModelProperty(value="根据什么排序（不填）",name="sortField",example="", position = 2)
    private String sortField;

    @ApiModelProperty(value="降序或升序（不填）",name="sortOrder",example="", position = 3)
    private String sortOrder;


}
