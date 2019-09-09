package com.anzhi.solidwaste.common.service;



import com.anzhi.solidwaste.common.domain.UploadObject;

import java.io.IOException;

/**
 * @author andy
 * @date 2019/7/18 11:28
 */
public interface UploadService {

    void uploadImage(UploadObject uploadObject) throws IOException;

    void uploadFile(UploadObject uploadObject) throws IOException;

}
