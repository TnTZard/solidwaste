package com.anzhi.solidwaste.system.service.impl;

import com.anzhi.solidwaste.common.utils.CodeUtil;
import com.anzhi.solidwaste.common.utils.MD5Util;
import com.anzhi.solidwaste.system.dto.UserDto;
import com.anzhi.solidwaste.system.entity.User;
import com.anzhi.solidwaste.system.manager.UserManager;
import com.anzhi.solidwaste.system.mapper.UserMapper;
import com.anzhi.solidwaste.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Anzhi
 * @since 2019-09-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserManager userManager;

    @Override
    public User createUser(UserDto userDto) throws Exception {
        User user = new User();
        //user.setAccount(CodeUtil.randomGenerate(6));
        user.setAccount(userDto.getAccount());
        user.setPassword(MD5Util.encrypt(userDto.getAccount(), User.DEFAULT_PASSWORD));

        save(user);

        this.userManager.loadUserRedisCache(user);
        return user;
    }
}
