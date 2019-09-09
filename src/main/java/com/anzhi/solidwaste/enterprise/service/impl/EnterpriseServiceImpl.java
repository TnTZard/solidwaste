package com.anzhi.solidwaste.enterprise.service.impl;

import com.anzhi.solidwaste.common.domain.UploadObject;
import com.anzhi.solidwaste.common.exception.AzException;
import com.anzhi.solidwaste.enterprise.entity.Enterprise;
import com.anzhi.solidwaste.enterprise.mapper.EnterpriseMapper;
import com.anzhi.solidwaste.enterprise.service.EnterpriseService;
import com.anzhi.solidwaste.system.entity.File;
import com.anzhi.solidwaste.system.mapper.FileMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Service
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise> implements EnterpriseService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    @Transactional(rollbackFor = AzException.class)
    public void createEnterprise(Enterprise enterprise, UploadObject uploadObject) {

        // 得到上传的文件名和路径 存进file表
        Map<String, String> fileInfo = uploadObject.getFileInfo();
        fileInfo.forEach((fileName, filePath) -> {
            File file = new File();
            file.setName(fileName);
            file.setPath(filePath);
            file.setRelatedEnterprise(enterprise.getName());
            this.fileMapper.insert(file);
        });

        this.save(enterprise);
    }
}
