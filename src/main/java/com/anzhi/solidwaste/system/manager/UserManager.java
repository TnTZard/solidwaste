package com.anzhi.solidwaste.system.manager;

import com.anzhi.solidwaste.common.authentication.JWTUtil;
import com.anzhi.solidwaste.common.service.CacheService;
import com.anzhi.solidwaste.common.utils.AzUtil;
import com.anzhi.solidwaste.system.entity.Menu;
import com.anzhi.solidwaste.system.entity.Role;
import com.anzhi.solidwaste.system.entity.User;

import com.anzhi.solidwaste.system.service.MenuService;
import com.anzhi.solidwaste.system.service.RoleService;
import com.anzhi.solidwaste.system.service.UserRoleService;
import com.anzhi.solidwaste.system.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author anzhi
 * @date 2019/9/3 11:52
 */
@Slf4j
@Service
public class UserManager {

    @Autowired
    private CacheService cacheService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    public User getUser(String account){
        return AzUtil.selctCacheByTenplate(
                () -> this.cacheService.getUser(account),
                () -> this.userService.getOne(new LambdaQueryWrapper<User>().eq(User::getAccount, account)));
    }


//    public Set<String> getUserRoles(String account){
//        List<Role> roleList = AzUtil.selctCacheByTenplate(
//                () -> this.cacheService.getRoles(account),
//                () -> this.roleService.findUserRole(account));
//        return roleList.stream().map(Role::getName).collect(Collectors.toSet());
//    }
//
//    public Set<String> getUserResources(String account){
//        List<Menu> menuList = AzUtil.selctCacheByTenplate(
//                () -> this.cacheService.getMenus(account),
//                () -> this.menuService.findUserResources(account));
//        return menuList.stream().map(Menu::getName).collect(Collectors.toSet());
//    }


    public void loadUserRedisCache(User user) throws Exception{
        cacheService.saveUser(user.getAccount());

        cacheService.saveRoles(user.getAccount());

        cacheService.savePermissions(user.getAccount());
    }

    public void loadUserList(List<User> users) throws Exception{
        cacheService.savaUserList(users);
    }

    public User getCurrentUser() {

        String account = JWTUtil.getAccount((String) SecurityUtils.getSubject().getPrincipal());

        User user = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getAccount, account));
//        List<String> roles = new ArrayList<>();
//        LambdaQueryWrapper<UserRole> userRoleLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        userRoleLambdaQueryWrapper.eq(UserRole::getUserId, user.getId());
//        List<UserRole> userRoles = this.userRoleService.list(userRoleLambdaQueryWrapper);
//
//        userRoles.forEach( ur -> {
//            LambdaQueryWrapper<Role> roleLambdaQueryWrapper = new LambdaQueryWrapper<>();
//            roleLambdaQueryWrapper.eq(Role::getId, ur.getRoleId());
//            Role role = this.roleService.getOne(roleLambdaQueryWrapper);
//            roles.add(role.getName());
//        });
//
//        user.setRoles(roles);
        return user;
    }


}

