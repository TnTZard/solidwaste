package com.anzhi.solidwaste.enterprise.service.impl;

import com.anzhi.solidwaste.common.exception.AzException;
import com.anzhi.solidwaste.common.utils.CodeUtil;
import com.anzhi.solidwaste.enterprise.entity.Depot;
import com.anzhi.solidwaste.enterprise.entity.HazardousWaste;
import com.anzhi.solidwaste.enterprise.mapper.DepotMapper;
import com.anzhi.solidwaste.enterprise.mapper.HazardousWasteMapper;
import com.anzhi.solidwaste.enterprise.service.DepotService;
import com.anzhi.solidwaste.repertory.dto.InStorageDto;
import com.anzhi.solidwaste.repertory.dto.InStorageWasteDto;
import com.anzhi.solidwaste.repertory.entity.InStorage;
import com.anzhi.solidwaste.repertory.entity.OutStorage;
import com.anzhi.solidwaste.repertory.mapper.InStorageMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Service
public class DepotServiceImpl extends ServiceImpl<DepotMapper, Depot> implements DepotService {

    @Autowired
    private InStorageMapper inStorageMapper;

    @Autowired
    private HazardousWasteMapper hazardousWasteMapper;

    @Override
    @Transactional(rollbackFor = AzException.class)
    public void inStorage(InStorageDto inStorageDto) {
        // 新增入库  记录危废的批次  该批次

        // 插入入库记录
        InStorage inStorage = generateInStorage(inStorageDto);
        this.inStorageMapper.insert(inStorage);

        // 获得批次编号
        String batchNumber = inStorage.getName();

//        String unique_id

        // 插入危废
        List<InStorageWasteDto> inStorageWasteDtoList = inStorageDto.getInStorageWasteDtoList();
        for(InStorageWasteDto isw:inStorageWasteDtoList) {



            // 新增时 即使入库的危废在库内存在相同危废 依然按照不同批次 将其视为不同的危废（入库的时间不同）
            // 那么这样在入库的时候就不用 改变数量了 只需要记录该批次该类危废的数量就可以了
            this.hazardousWasteMapper.insert(generateWaste(isw, batchNumber, inStorageDto));


        }

    }

    @Override
    @Transactional(rollbackFor = AzException.class)
    public void outStorage(OutStorage outStorage) {
        // 出库的时候

        // 插入出库记录

    }






    /**
     * 构造出库对象
     * @param inStorageDto
     * @return
     */
    public static InStorage generateInStorage(InStorageDto inStorageDto) {
        if (inStorageDto == null) {
            return null;
        }
        InStorage inStorage = new InStorage();
        // 生成入库编号
        inStorage.setName(CodeUtil.createEventId());

        inStorage.setEnterpriseName(inStorageDto.getEnterpriseName());
        inStorage.setIndustryCategory(inStorageDto.getIndustryCategory());
        inStorage.setDepotId(inStorageDto.getDepotId());
        inStorage.setWasteCategory(inStorageDto.getWasteCategory());
        inStorage.setWasteCode(inStorageDto.getWasteCode());
        inStorage.setDealPerson(inStorageDto.getDealPerson());
        //inStorage.setInStorageWasteDtoList(inStorageDto.getInStorageWasteDtoList());
        return inStorage;
    }

    /**
     * 构造危废对象
     * @param inStorageWasteDto
     * @param batchNumber
     * @param inStorageDto
     * @return
     */
    public static HazardousWaste generateWaste(InStorageWasteDto inStorageWasteDto, String batchNumber, InStorageDto inStorageDto) {
        if (inStorageWasteDto == null) {
            return null;
        }
        HazardousWaste hazardousWaste = new HazardousWaste();

        hazardousWaste.setDepotId(inStorageDto.getDepotId());
        hazardousWaste.setWasteCategory(inStorageDto.getWasteCategory());
        hazardousWaste.setWasteCode(inStorageDto.getWasteCode());
        hazardousWaste.setName(inStorageWasteDto.getWasteName());
        hazardousWaste.setFeature(inStorageWasteDto.getWasteFeature());
        hazardousWaste.setPhysicalState(inStorageWasteDto.getPhysicalState());
        hazardousWaste.setTransferAmount(inStorageWasteDto.getTransferAmount());
        hazardousWaste.setExistAmount(inStorageWasteDto.getTransferAmount());
        hazardousWaste.setPacking(inStorageWasteDto.getPacking());
        hazardousWaste.setBatchNumber(batchNumber);
        hazardousWaste.setMeasurement(inStorageWasteDto.getMeasurement());
        return hazardousWaste;
    }
}
