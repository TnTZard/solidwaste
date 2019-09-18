package com.anzhi.solidwaste.enterprise.search;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anzhi
 * @date 2019/9/9 15:29
 */
@Data
public class AreaSearch {

    @ApiModelProperty(value = "区域")
    private String area;

    @ApiModelProperty(value = "街道")
    private String street;

}
