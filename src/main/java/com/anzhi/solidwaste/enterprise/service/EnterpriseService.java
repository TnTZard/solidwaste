package com.anzhi.solidwaste.enterprise.service;

import com.anzhi.solidwaste.common.domain.UploadObject;
import com.anzhi.solidwaste.enterprise.entity.Enterprise;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
public interface EnterpriseService extends IService<Enterprise> {
    /**
     * 新增企业
     * @param enterprise
     * @param uploadObject
     * @return
     */
    void createEnterprise(Enterprise enterprise, UploadObject uploadObject);

}
