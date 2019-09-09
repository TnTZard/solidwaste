package com.anzhi.solidwaste.common.service;


import com.anzhi.solidwaste.system.entity.Menu;
import com.anzhi.solidwaste.system.entity.Role;
import com.anzhi.solidwaste.system.entity.User;

import java.util.List;
import java.util.Set;

/**
 * @author andy
 * @date 2019/7/1 11:08
 */

public interface CacheService {
    /**
     * 测试 Redis是否连接成功
     */
    void testConnect() throws Exception;

    /**
     * 从缓存中获取用户
     *
     * @param account 用户名
     * @return User
     */
    User getUser(String account) throws Exception;


    List<User> getUserList() throws Exception;
    /**
     * 从缓存中获取用户角色
     *
     * @param account 用户名
     * @return 角色集
     */
    List<Role> getRoles(String account) throws Exception;

    /**
     * 从缓存中获取用户权限
     *
     * @param account 用户名
     * @return 权限集
     */
    List<Menu> getMenus(String account) throws Exception;

    /**
     * 从缓存中获取用户个性化配置
     *
     * @param userId 用户 ID
     * @return 个性化配置
     */
//    UserConfig getUserConfig(String userId) throws Exception;

    /**
     * 缓存用户信息，只有当用户信息是查询出来的，完整的，才应该调用这个方法
     * 否则需要调用下面这个重载方法
     *
     * @param user 用户信息
     */
    void saveUser(User user) throws Exception;

    /**
     * 缓存用户信息
     *
     * @param account 用户名
     */
    void saveUser(String account) throws Exception;

    void savaUserList(List<User> users) throws Exception;
    /**
     * 缓存用户角色信息
     *
     * @param account 用户名
     */
    void saveRoles(String account) throws Exception;

    /**
     * 缓存用户权限信息
     *
     * @param account 用户名
     */
    void savePermissions(String account) throws Exception;

    /**
     * 缓存用户个性化配置
     *
     * @param userId 用户 ID
     */
    void saveUserConfigs(String userId) throws Exception;

    /**
     * 删除用户信息
     *
     * @param account 用户名
     */
    void deleteUser(String account) throws Exception;

    /**
     * 删除用户角色信息
     *
     * @param account 用户名
     */
    void deleteRoles(String account) throws Exception;

    /**
     * 删除用户权限信息
     *
     * @param account 用户名
     */
    void deletePermissions(String account) throws Exception;

    /**
     * 删除用户个性化配置
     *
     * @param userId 用户 ID
     */
    void deleteUserConfigs(String userId) throws Exception;


}
