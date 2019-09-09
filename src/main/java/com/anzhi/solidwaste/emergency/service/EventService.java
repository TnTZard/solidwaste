package com.anzhi.solidwaste.emergency.service;

import com.anzhi.solidwaste.emergency.entity.Event;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
public interface EventService extends IService<Event> {


    void createEvent(Event event, MultipartFile[] files) throws IOException;



}
