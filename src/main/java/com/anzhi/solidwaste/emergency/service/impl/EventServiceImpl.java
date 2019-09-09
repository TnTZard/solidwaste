package com.anzhi.solidwaste.emergency.service.impl;

import com.anzhi.solidwaste.common.domain.UploadObject;
import com.anzhi.solidwaste.common.exception.AzException;
import com.anzhi.solidwaste.common.service.UploadService;
import com.anzhi.solidwaste.emergency.entity.Event;
import com.anzhi.solidwaste.emergency.mapper.EventMapper;
import com.anzhi.solidwaste.emergency.service.EventService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Service
public class EventServiceImpl extends ServiceImpl<EventMapper, Event> implements EventService {


    @Autowired
    private UploadService uploadService;

    @Autowired
    private EventMapper eventMapper;

    @Override
    @Transactional(rollbackFor = AzException.class)
    public void createEvent(Event event, MultipartFile[] files) throws IOException {
        UploadObject uploadObject = new UploadObject(files);
        this.uploadService.uploadFile(uploadObject);




    }



}
