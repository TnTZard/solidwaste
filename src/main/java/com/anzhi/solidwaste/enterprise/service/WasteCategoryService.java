package com.anzhi.solidwaste.enterprise.service;

import com.anzhi.solidwaste.enterprise.dto.WasteCategoryDto;
import com.anzhi.solidwaste.enterprise.entity.WasteCategory;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
public interface WasteCategoryService extends IService<WasteCategory> {

    /**
     * 获得危废类别
     * @return
     */
    List<WasteCategoryDto> getAllCategories();


}
