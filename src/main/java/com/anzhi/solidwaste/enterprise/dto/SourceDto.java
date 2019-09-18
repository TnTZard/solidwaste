package com.anzhi.solidwaste.enterprise.dto;

import com.anzhi.solidwaste.enterprise.entity.WasteCategory;
import lombok.Data;

import java.util.List;

/**
 * @author anzhi
 * @date 2019/9/16 17:25
 */
@Data
public class SourceDto {

    private String source;

    private List<WasteDto> wasteDtos;

}
