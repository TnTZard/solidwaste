package com.anzhi.solidwaste.system.service.impl;

import com.anzhi.solidwaste.common.domain.UploadObject;
import com.anzhi.solidwaste.common.exception.AzException;
import com.anzhi.solidwaste.common.service.UploadService;
import com.anzhi.solidwaste.common.utils.CodeUtil;
import com.anzhi.solidwaste.common.utils.MD5Util;
import com.anzhi.solidwaste.enterprise.entity.Enterprise;
import com.anzhi.solidwaste.enterprise.service.EnterpriseService;
import com.anzhi.solidwaste.system.common.Constants;
import com.anzhi.solidwaste.system.dto.UserDto;
import com.anzhi.solidwaste.system.entity.Role;
import com.anzhi.solidwaste.system.entity.User;
import com.anzhi.solidwaste.system.entity.UserEnterprise;
import com.anzhi.solidwaste.system.entity.UserRole;
import com.anzhi.solidwaste.system.manager.UserManager;
import com.anzhi.solidwaste.system.mapper.RoleMapper;
import com.anzhi.solidwaste.system.mapper.UserEnterpriseMapper;
import com.anzhi.solidwaste.system.mapper.UserMapper;
import com.anzhi.solidwaste.system.mapper.UserRoleMapper;
import com.anzhi.solidwaste.system.service.UserService;
import com.anzhi.solidwaste.web.common.EnterpriseDto;
import com.anzhi.solidwaste.web.common.EnvironmentDto;
import com.anzhi.solidwaste.web.common.NormalUserDto;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserManager userManager;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserEnterpriseMapper userEnterpriseMapper;

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private UploadService uploadService;

    @Override
    public User createUser(UserDto userDto) throws Exception {
        User user = new User();
        user.setAccount(userDto.getAccount());
        user.setPassword(MD5Util.encrypt(userDto.getAccount(), User.DEFAULT_PASSWORD));


        // 存入数据库后 可以得到user的ID
        this.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleId(userDto.getRoleId());
        userRole.setUserId(user.getId());
        this.userRoleMapper.insert(userRole);

        this.userManager.loadUserRedisCache(user);
        return user;
    }

    @Override
    @Transactional(rollbackFor = AzException.class)
    public void registerEnterprise(EnterpriseDto enterpriseDto, MultipartFile[] files) throws IOException {
        // 构建用户
        User user = new User();
        user.setAccount(enterpriseDto.getAccount());
        user.setPassword(MD5Util.encrypt(enterpriseDto.getAccount(), enterpriseDto.getPassword()));
        user.setType(Constants.TYPE_ENTERPRISE);

        // 用户状态为 未审核
        user.setIsActive(Constants.UNCHECK);
        this.save(user);

        // 企业法人角色
        Role role = this.roleMapper.selectOne(new LambdaQueryWrapper<Role>()
                .eq(Role::getName, "corporate"));
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        this.userRoleMapper.insert(userRole);

        // Dto -> entity
        Enterprise enterprise = generateEnterprise(enterpriseDto);
        // 在这里执行 新增企业的操作
        this.enterpriseService.createEnterprise(enterprise, files);

        // 绑定用户和企业
        UserEnterprise userEnterprise = new UserEnterprise();
        userEnterprise.setEnterpriseName(enterprise.getName());
        userEnterprise.setUserAccount(user.getAccount());
        this.userEnterpriseMapper.insert(userEnterprise);

    }

    @Override
    @Transactional(rollbackFor = AzException.class)
    public void registerEnvironment(EnvironmentDto environmentDto) {
        User user = new User();
        user.setAccount(environmentDto.getAccount());
        user.setPassword(MD5Util.encrypt(environmentDto.getAccount(), environmentDto.getPassword()));
        user.setGender(environmentDto.getGender());
        user.setTelephone(environmentDto.getPhone());
        // 未审核
        user.setIsActive(Constants.UNCHECK);
        user.setType(Constants.TYPE_ENVIRONMENT);
        this.save(user);

        // 用户角色 环保管理员
        Role role = this.roleMapper.selectOne(new LambdaQueryWrapper<Role>()
                .eq(Role::getName, "manager"));
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        this.userRoleMapper.insert(userRole);
    }

    @Override
    public void registerUser(NormalUserDto normalUserDto, MultipartFile[] files) throws IOException {
        User user = generateUser(normalUserDto);
        user.setAccount(normalUserDto.getAccount());
        user.setPassword(MD5Util.encrypt(normalUserDto.getAccount(), normalUserDto.getPassword()));

        // 上传身份证
        UploadObject uploadObject = new UploadObject(files);
        this.uploadService.uploadFile(uploadObject);
        List<String> idCardPathList = new LinkedList<>();
        for(String s:uploadObject.getFileInfo().values()){
            idCardPathList.add(s);
        }
        // 设置图片路径
        user.setIdCardBack(idCardPathList.get(0));
        user.setIdCardFront(idCardPathList.get(1));

        this.save(user);

        // 职务 -> 角色   给前端发 角色名列表
        String position = user.getPosition();
        Role role = this.roleMapper.selectOne(new LambdaQueryWrapper<Role>()
                .eq(Role::getName, position));
        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        this.userRoleMapper.insert(userRole);
    }

    @Override
    public List<User> getUncheckUsers() {
       return this.baseMapper.selectList(new LambdaQueryWrapper<User>().eq(User::getIsActive, Constants.UNCHECK));
    }

    @Override
    public void reviewUser() {

    }


    public static Enterprise generateEnterprise(EnterpriseDto enterpriseDto) {
        if (enterpriseDto == null) {
            return null;
        }
        Enterprise enterprise = new Enterprise();
        enterprise.setName(enterpriseDto.getName());
        enterprise.setIndustryCategory(enterpriseDto.getIndustryCategory());
        enterprise.setLegalRepresentative(enterpriseDto.getLegalRepresentative());
        enterprise.setRegisteredAddress(enterpriseDto.getRegisteredAddress());
        enterprise.setBusinessLicense(enterpriseDto.getBusinessLicense());
        enterprise.setBusinessScale(enterpriseDto.getBusinessScale());
        enterprise.setRegisteredCapital(enterpriseDto.getRegisteredCapital());
        enterprise.setIndustryCategoryCode(enterpriseDto.getIndustryCategoryCode());
        enterprise.setWasteCategory(enterpriseDto.getWasteCategory());
        enterprise.setWasteName(enterpriseDto.getWasteName());
        enterprise.setWasteCode(enterpriseDto.getWasteCode());
        enterprise.setWasteProduction(enterpriseDto.getWasteProduction());
        enterprise.setWasteFeature(enterpriseDto.getWasteFeature());
        enterprise.setDepotPosition(enterpriseDto.getDepotPosition());
        enterprise.setDepotNum(enterpriseDto.getDepotNum());
        enterprise.setEnvironmentPerson(enterpriseDto.getEnvironmentPerson());
        enterprise.setApprovedMode(enterpriseDto.getApprovedMode());
        enterprise.setEmergencyContact(enterpriseDto.getEmergencyContact());
        enterprise.setStreet(enterpriseDto.getStreet());
        enterprise.setDepotList(enterpriseDto.getDepotList());
        enterprise.setWasteCategories(enterpriseDto.getWasteCategories());

        return enterprise;
    }

    public static User generateUser(NormalUserDto normalUserDto) {
        if (normalUserDto == null) {
            return null;
        }
        User user = new User();
        user.setUsername(normalUserDto.getUsername());
        user.setPassword(normalUserDto.getPassword());
        user.setEmail(normalUserDto.getEmail());
        user.setGender(normalUserDto.getGender());
        user.setAvatar(normalUserDto.getAvatar());
        user.setTelephone(normalUserDto.getTelephone());
        user.setFixedLine(normalUserDto.getFixedLine());
        user.setAddress(normalUserDto.getAddress());
        user.setSchool(normalUserDto.getSchool());
        user.setProfession(normalUserDto.getProfession());
        user.setPosition(normalUserDto.getPosition());
        user.setCompany(normalUserDto.getCompany());
        user.setIdentity(normalUserDto.getIdentity());

        return user;
    }

}
