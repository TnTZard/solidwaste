package com.anzhi.solidwaste.sys.controller;

import com.anzhi.solidwaste.common.response.*;
import com.anzhi.solidwaste.sys.dto.Role;
import com.anzhi.solidwaste.sys.dto.User;
import com.anzhi.solidwaste.sys.entity.Test;
import com.anzhi.solidwaste.sys.service.TestService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Anzhi
 * @since 2019-08-29
 */
@Api(tags = "")
@RestController
@RequestMapping("/sys/test")
public class TestController {


    @Autowired
    private TestService testService;


    @PostMapping("/")
    public AzResponse add(@Validated @RequestBody Object vo){
        return null;
    }

    @ApiOperation("测试接口")
    @GetMapping("/")
    public AzResponse<User> get(){

        List<Role> roles = new ArrayList<>();
        List<User> users = new ArrayList<>();
        Role role1 = new Role(1L, "角色1");
        Role role2 = new Role(2L, "角色2");
        Role role3 = new Role(3L, "角色3");

        roles.add(role1);
        roles.add(role2);
        roles.add(role3);

        User user1 = new User();
        User user2 = new User();
        user1.setAccount("test1").setGender("男").setPassword("123").setRoles(roles);
        user2.setAccount("test2").setGender("女").setPassword("123").setRoles(roles);


        Map<String, String> map = new HashMap<>();
        map.put("car", "baoma");
        map.put("student", "tom");



        user1.setMap(map);
        users.add(user1);
        users.add(user2);


        return new AzResponse(true, users, 200, "");
    }


    @GetMapping("/map")
    public AzResponse get2() {
        AzResponse azResponse = new AzResponse();
        Map<String, String> map = new HashMap<>();
        map.put("car", "BMW");
        map.put("student", "tom");

        azResponse.setData(map);

        return azResponse;
    }

    @GetMapping("/page")
    public AzResponse page(@ApiParam(name = "page", value = "页码", defaultValue = "1") @RequestParam(defaultValue = "1") Integer page,
    @ApiParam(name = "size", value = "每页返回数", defaultValue = "15") @RequestParam(defaultValue = "15") Integer size){

        Page<Test> page1 = new Page<>(page, size);
        page1.setDesc("number");
        AzResponse azResponse = new AzResponse();
        azResponse.setData(this.testService.findByPage(page1));

        return azResponse;
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
