package com.anzhi.solidwaste.system.controller;

import com.anzhi.solidwaste.common.response.*;
import com.anzhi.solidwaste.common.domain.QueryRequest;
import com.anzhi.solidwaste.system.dto.UserDto;
import com.anzhi.solidwaste.system.entity.User;
import com.anzhi.solidwaste.system.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("新增用户")
    @PostMapping("/")
    public AzResponse<User> add(@Validated @RequestBody UserDto userDto) throws Exception {
        User user =  this.userService.createUser(userDto);
        return new AzResponse(true, user, 200, "创建成功");
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
