package com.anzhi.solidwaste.test.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Anzhi
 */
@Api(tags = "")
@RestController
@RequestMapping("/test/t-test")
public class TTestController {

    @PostMapping("/")
    public Object add(@Validated @RequestBody Object vo){
        return null;
    }

    @GetMapping("/")
    public Object get(@ApiParam(name = "id", value = "id") @RequestParam String id){
        return null;
    }

    @GetMapping("/page")
    public Object page(@ApiParam(name = "page", value = "页码", defaultValue = "1") @RequestParam(defaultValue = "1") Integer page,
    @ApiParam(name = "size", value = "每页返回数", defaultValue = "15") @RequestParam(defaultValue = "15") Integer size){
        return null;
    }

    @PutMapping("/")
    public Object update(@Validated @RequestBody Object vo){
        return null;
    }

    @DeleteMapping("/")
    public Object delete(@ApiParam(name = "id", value = "id") @RequestParam String id){
        return null;
    }
}
