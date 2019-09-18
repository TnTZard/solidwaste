package com.anzhi.solidwaste.enterprise.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.anzhi.solidwaste.enterprise.dto.SourceDto;
import com.anzhi.solidwaste.enterprise.dto.WasteCategoryDto;
import com.anzhi.solidwaste.enterprise.dto.WasteDto;
import com.anzhi.solidwaste.enterprise.entity.WasteCategory;
import com.anzhi.solidwaste.enterprise.mapper.WasteCategoryMapper;
import com.anzhi.solidwaste.enterprise.service.WasteCategoryService;
import com.anzhi.solidwaste.system.entity.Waste;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.xml.transform.Source;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Service
public class WasteCategoryServiceImpl extends ServiceImpl<WasteCategoryMapper, WasteCategory> implements WasteCategoryService {

    @Override
    public List<WasteCategoryDto> getAllCategories() {

        List<WasteCategory> result = this.baseMapper.selectList(null);

        List<WasteCategoryDto> wasteCategoryDtoList = new ArrayList<>();
        Map<String, Map<String, List<WasteCategory>>> map = result.stream().collect(
                Collectors.groupingBy(WasteCategory::getCategoryCode, TreeMap::new, Collectors.groupingBy(WasteCategory::getSource, TreeMap::new, Collectors.toList())));
        map.forEach((k,v) -> {
            WasteCategoryDto wasteCategoryDto = new WasteCategoryDto();
            wasteCategoryDto.setCode(k);
            List<SourceDto> sourceDtoList = new ArrayList<>();
            v.forEach((k1, v1) -> {
                SourceDto sourceDto = new SourceDto();
                sourceDto.setSource(k1);
                List<WasteDto> wasteDtoList = new ArrayList<>();
                v1.stream().forEach( wasteCategory -> {
                    WasteDto wasteDto = new WasteDto();
                    wasteDto.setCode(wasteCategory.getWasteCode());
                    wasteDto.setDescription(wasteCategory.getDescription());
                    wasteDto.setFeature(wasteCategory.getFeature());
                    wasteCategoryDto.setName(wasteCategory.getCategoryName());
                    wasteDtoList.add(wasteDto);
                    sourceDto.setWasteDtos(wasteDtoList);
                });
                sourceDtoList.add(sourceDto);

                wasteCategoryDto.setSourceDtos(sourceDtoList);
            });
            wasteCategoryDtoList.add(wasteCategoryDto);
        });



        return wasteCategoryDtoList;
    }




}