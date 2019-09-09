package com.anzhi.solidwaste.system.service;

import com.anzhi.solidwaste.system.dto.UserDto;
import com.anzhi.solidwaste.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
