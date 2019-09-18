package com.anzhi.solidwaste.enterprise.service.impl;

import com.anzhi.solidwaste.common.domain.UploadObject;
import com.anzhi.solidwaste.common.exception.AzException;
import com.anzhi.solidwaste.common.service.UploadService;
import com.anzhi.solidwaste.enterprise.entity.Enterprise;
import com.anzhi.solidwaste.enterprise.mapper.DepotMapper;
import com.anzhi.solidwaste.enterprise.mapper.EnterpriseMapper;
import com.anzhi.solidwaste.enterprise.service.EnterpriseService;
import com.anzhi.solidwaste.system.common.Constants;
import com.anzhi.solidwaste.system.entity.EnterpriseWaste;
import com.anzhi.solidwaste.system.entity.File;
import com.anzhi.solidwaste.system.mapper.FileMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Service
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise> implements EnterpriseService {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private FileMapper fileMapper;

    @Autowired
    private DepotMapper depotMapper;

    @Override
    @Transactional(rollbackFor = AzException.class)
    public void createEnterprise(Enterprise enterprise, MultipartFile[] files) throws IOException {

        UploadObject uploadObject = new UploadObject(files);
        this.uploadService.uploadFile(uploadObject);
        // 得到上传的文件名和路径 存进file表
        Map<String, String> fileInfo = uploadObject.getFileInfo();
        fileInfo.forEach((fileName, filePath) -> {
            File file = new File();
            file.setName(fileName);
            file.setPath(filePath);
            file.setRelatedEnterprise(enterprise.getName());
            this.fileMapper.insert(file);
        });


        // 企业状态为未审核
        enterprise.setIsActive(Constants.UNCHECK);
        this.save(enterprise);

        // 危废类别 、危废名称与代码是企业的自有属性, 与仓库有无危废无关




        // 危废类别 1<-->n 危废代码 1<-->n 危废名称


        EnterpriseWaste enterpriseWaste = new EnterpriseWaste();
        enterpriseWaste.setEnterpriseId(enterprise.getId());
        enterpriseWaste.setWasteCategoryId(0);
        // TODO


    }
}
