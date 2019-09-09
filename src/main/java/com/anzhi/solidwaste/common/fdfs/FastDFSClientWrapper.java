package com.anzhi.solidwaste.common.fdfs;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.exception.FdfsUnsupportStorePathException;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Component
public class FastDFSClientWrapper {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private AppConfig appConfig;

    //上传文件
//    public String uploadFile(byte[] bytes, long fileSize, String extension) {
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
//        StorePath storePath = storageClient.uploadFile(byteArrayInputStream, fileSize, extension, null);
//        System.out.println(storePath.getGroup() + "===" + storePath.getPath() + "======" + storePath.getFullPath());
//        return storePath.getFullPath();
//    }
    public String uploadFile(MultipartFile file) throws IOException {
//		System.out.println(file.getOriginalFilename());
        StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        System.out.println(storePath.getFullPath());
        return storePath.getFullPath();
    }

    //封装图片完整url地址
    private String getResAccessUrl(StorePath storePath) {
        String fileUrl = "http://" + appConfig.getResHost() + ":" + appConfig.getStoragePort() + "/" + storePath.getFullPath();
        return fileUrl;
    }

    //	删除文件
    public String deleteFile(String fileUrl) {
        if (StringUtils.isEmpty(fileUrl)) {
            return "文件路径为空";
        }
        try {
            StorePath storePath = StorePath.praseFromUrl(fileUrl);
            System.out.println(storePath);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
            return "ok";
        } catch (FdfsUnsupportStorePathException e) {
            log.warn(e.getMessage());
            return "error";
        }
    }
}
