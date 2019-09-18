package com.anzhi.solidwaste.enterprise.dto;

import lombok.Data;

import java.util.List;

/**
 * @author anzhi
 * @date 2019/9/16 17:21
 */

@Data
public class WasteCategoryDto {

    private String name;

    private String code;

    private List<SourceDto> sourceDtos;

}
