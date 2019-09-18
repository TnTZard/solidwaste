package com.anzhi.solidwaste.system.service;

import com.anzhi.solidwaste.system.dto.UserDto;
import com.anzhi.solidwaste.system.entity.User;
import com.anzhi.solidwaste.web.common.EnterpriseDto;
import com.anzhi.solidwaste.web.common.EnvironmentDto;
import com.anzhi.solidwaste.web.common.NormalUserDto;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
public interface UserService extends IService<User> {


    /**
     * 创建用户
     * @param userDto
     * @return
     * @throws Exception
     */
    User createUser(UserDto userDto) throws Exception;


    /**
     * 企业账号注册
     * @param enterpriseDto
     * @param files
     * @throws IOException
     */
    void registerEnterprise(EnterpriseDto enterpriseDto, MultipartFile[] files) throws IOException;

    /**
     * 环保管理人员注册
     * @param environmentDto
     */
    void registerEnvironment(EnvironmentDto environmentDto);

    /**
     * 个人账号注册
     * @param normalUserDto
     * @param files
     */
    void registerUser(NormalUserDto normalUserDto, MultipartFile[] files) throws IOException;




    /**
     * 获取未审核用户名单
     * @return
     */
    List<User> getUncheckUsers();


    /**
     * 审核用户
     */
    void reviewUser();




}
