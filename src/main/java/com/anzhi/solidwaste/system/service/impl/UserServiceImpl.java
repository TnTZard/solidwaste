package com.anzhi.solidwaste.system.service.impl;

import com.anzhi.solidwaste.system.entity.User;
import com.anzhi.solidwaste.system.mapper.UserMapper;
import com.anzhi.solidwaste.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Anzhi
 * @since 2019-09-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
