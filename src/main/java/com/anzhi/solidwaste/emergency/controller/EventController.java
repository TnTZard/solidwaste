package com.anzhi.solidwaste.emergency.controller;

import com.anzhi.solidwaste.common.response.*;
import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.emergency.entity.Event;
import com.anzhi.solidwaste.emergency.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Api(tags = "事件管理")
@RestController
@RequestMapping("/emergency/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/")
    public AzResponse add(@Validated Event event, @RequestParam("files") MultipartFile[] files){

        //this.eventService.create()



        return null;
    }

    @GetMapping("/")
    public AzResponse get(@ApiParam(name = "id", value = "id") @RequestParam String id){
        return null;
    }

    @GetMapping("/page")
    public AzResponse page(QueryRequest queryRequest, Object vo){
        return null;
    }

    @PutMapping("/")
    public AzResponse update(@Validated @RequestBody Object vo){
        return null;
    }

    @DeleteMapping("/")
    public AzResponse delete(@ApiParam(name = "id", value = "id") @RequestParam String id){
        return null;
    }
}
