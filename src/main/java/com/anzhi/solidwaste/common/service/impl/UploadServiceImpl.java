package com.anzhi.solidwaste.common.service.impl;


import com.anzhi.solidwaste.common.domain.UploadObject;
import com.anzhi.solidwaste.common.fdfs.FastDFSClientWrapper;
import com.anzhi.solidwaste.common.service.UploadService;
import com.anzhi.solidwaste.common.utils.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author andy
 * @date 2019/7/18 11:28
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private FastDFSClientWrapper fastDFSClientWrapper;

    @Override
    public void uploadImage(UploadObject uploadObject) throws IOException {
        StringBuffer res_photo = new StringBuffer();
        StringBuffer res_video = new StringBuffer();
        if (uploadObject.getFiles() != null) {
            //uploadObject.setName();
            uploadObject.setPath(createUrl(uploadObject.getFiles(), res_photo).toString());
            System.out.println("(。・_・)/~~~-----------------------   " + uploadObject.getPath() + "(。・_・)/");
        } else {
            uploadObject.setPath(null);
            System.out.println("(。・_・)/~~~-----------------------   " + uploadObject.getPath() + "(。・_・)/");
        }
    }


    private StringBuffer createUrl(MultipartFile[] files, StringBuffer res) throws IOException {
        StringBuffer sb ;
        for (MultipartFile file : files) {
            sb = new StringBuffer();
            String url = CodeUtil.dealURL(sb.append(fastDFSClientWrapper.uploadFile(file) + ",").toString());
            res.append(url);
        }
        return res;
    }


    @Override
    public void uploadFile(UploadObject uploadObject) throws IOException {
        StringBuffer res_photo = new StringBuffer();
        StringBuffer res_video = new StringBuffer();
        if (uploadObject.getFiles() != null) {

            Map<String,String> info = createFileInfo(uploadObject.getFiles());
            uploadObject.setFileInfo(info);
            System.out.println("(。・_・)/~~~-----------------------   " + uploadObject.getPath() + "(。・_・)/");
        } else {
            uploadObject.setPath(null);
            System.out.println("(。・_・)/~~~-----------------------   " + uploadObject.getPath() + "(。・_・)/");
        }
    }


    private Map<String, String> createFileInfo(MultipartFile[] files) throws IOException {
        Map<String, String> result = new LinkedHashMap<>();
        StringBuffer fileName ;
        StringBuffer filePath ;
        for (MultipartFile file : files) {
            fileName = new StringBuffer(file.getOriginalFilename());
            System.out.println("---------------------------   getOriginalFilename : " + file.getOriginalFilename());
            System.out.println("---------------------------   getName : " + file.getName());
            String url = CodeUtil.dealURL(fastDFSClientWrapper.uploadFile(file));
            filePath = new StringBuffer(url);
            result.put(fileName.toString(),filePath.toString());
        }
        return result;
    }
}
