package com.anzhi.solidwaste.enterprise.service;

import com.anzhi.solidwaste.enterprise.entity.Depot;
import com.anzhi.solidwaste.repertory.dto.InStorageDto;
import com.anzhi.solidwaste.repertory.entity.InStorage;
import com.anzhi.solidwaste.repertory.entity.OutStorage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
public interface DepotService extends IService<Depot> {


    void inStorage(InStorageDto inStorageDto);

    void outStorage(OutStorage outStorage);





}
