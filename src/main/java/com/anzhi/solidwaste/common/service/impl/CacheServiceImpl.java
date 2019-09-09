package com.anzhi.solidwaste.common.service.impl;


import com.anzhi.solidwaste.common.domain.AzConstant;
import com.anzhi.solidwaste.common.service.CacheService;
import com.anzhi.solidwaste.common.service.RedisService;
import com.anzhi.solidwaste.system.entity.Menu;
import com.anzhi.solidwaste.system.entity.Role;
import com.anzhi.solidwaste.system.entity.User;
import com.anzhi.solidwaste.system.mapper.UserMapper;
import com.anzhi.solidwaste.system.service.MenuService;
import com.anzhi.solidwaste.system.service.RoleService;
import com.anzhi.solidwaste.system.service.UserService;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author andy
 * @date 2019/7/1 11:10
 */
@Slf4j
@Service
public class CacheServiceImpl implements CacheService {


    @Autowired
    private RedisService redisService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private ObjectMapper mapper;

    @Override
    public void testConnect() throws Exception {
        this.redisService.exists("test");
    }

    @Override
    public User getUser(String account) throws Exception {
        String userString = this.redisService.get(AzConstant.USER_CACHE_PREFIX + account);
        if(StringUtils.isBlank(userString)){
            throw new Exception();
        } else {
            return this.mapper.readValue(userString, User.class);
        }
    }

    @Override
    public List<User> getUserList() throws Exception {
        String userListString = this.redisService.get(AzConstant.USER_LIST_CACHE_PREFIX);
        if(StringUtils.isBlank(userListString)){
            throw new Exception();
        }else {
            JavaType type = mapper.getTypeFactory().constructParametricType(List.class, User.class);
            return this.mapper.readValue(userListString, type);
        }
    }

    @Override
    public List<Role> getRoles(String account) throws Exception {
        String roleListString = this.redisService.get(AzConstant.USER_ROLE_CACHE_PREFIX + account);
        if(StringUtils.isBlank(roleListString)){
            throw new Exception();
        }else {
            JavaType type = mapper.getTypeFactory().constructParametricType(List.class, Role.class);
            return this.mapper.readValue(roleListString, type);
        }
    }

    @Override
    public List<Menu> getMenus(String account) throws Exception {
        String resourceListString = this.redisService.get(AzConstant.USER_PERMISSION_CACHE_PREFIX + account);
        if(StringUtils.isBlank(resourceListString)){
            throw new Exception();
        }else {
            JavaType type = mapper.getTypeFactory().constructParametricType(List.class, Role.class);
            return this.mapper.readValue(resourceListString, type);
        }
    }

    @Override
    public void saveUser(User user) throws Exception {
        String account = user.getAccount();
        this.deleteUser(account);
        redisService.set(AzConstant.USER_CACHE_PREFIX + account, mapper.writeValueAsString(user));
    }

    @Override
    public void saveUser(String account) throws Exception {
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>().eq(User::getAccount, account));
        this.deleteUser(account);
        redisService.set(AzConstant.USER_CACHE_PREFIX + account, mapper.writeValueAsString(user));
    }

    @Override
    public void savaUserList(List<User> users) throws Exception {
        log.info("缓存用户列表………………………………" + mapper.writeValueAsString(users));
        String s = redisService.set(AzConstant.USER_LIST_CACHE_PREFIX, mapper.writeValueAsString(users));
        log.info("缓存用户列表………………………………后" + s);
    }

    @Override
    public void saveRoles(String account) throws Exception {

    }

    @Override
    public void savePermissions(String account) throws Exception {
//        List<Menu> resourceList = this.resourceService.findUserResources(account);
//        if(!resourceList.isEmpty()){
//            this.deletePermissions(account);
//            redisService.set(AzConstant.USER_PERMISSION_CACHE_PREFIX + account, mapper.writeValueAsString(resourceList));
//        }
    }

    @Override
    public void saveUserConfigs(String userId) throws Exception {

    }

    @Override
    public void deleteUser(String account) throws Exception {
        account = account.toLowerCase();
        redisService.del(AzConstant.USER_CONFIG_CACHE_PREFIX + account);
    }

    @Override
    public void deleteRoles(String account) throws Exception {

    }

    @Override
    public void deletePermissions(String account) throws Exception {

    }

    @Override
    public void deleteUserConfigs(String userId) throws Exception {

    }



}

