package com.anzhi.solidwaste.common.authentication;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @author andy
 * @date 2019/7/1 9:39
 */
public class ShiroRealm extends AuthorizingRealm {

//    @Autowired
//    private RedisService redisService;
//
//    @Autowired
//    private UserManager userManager;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 授权模块，获取用户角色和权限
     * @param token
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection token) {
       String account = JWTUtil.getAccount(token.toString());

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

//        //获取用户角色集
//        Set<String> roleSet = userManager.getUserRoles(account);
//        simpleAuthorizationInfo.setRoles(roleSet);
//
//        Set<String> resourceSet = userManager.getUserResources(account);
//        simpleAuthorizationInfo.setStringPermissions(resourceSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     *
     * @param authenticationToken 身份认证 token
     * @return AuthenticationInfo 身份认证信息
     * @throws AuthenticationException 认证相关异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
//
//        // 从redis里获取这个token
//        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
//        String ip = IPUtil.getIpAddr(request);
//
//        String encryptToken = AzUtil.encryptToken(token);
//        String encryotTokenInRedis = null;
//
//        try {
//            encryotTokenInRedis = redisService.get(AzConstant.TOKEN_CACHE_PREFIX + encryptToken + "." + ip);
//        } catch (RedisConnectException e) {
//            e.printStackTrace();
//        }

//
//        //如果找不到 说明已经失效
//        if (StringUtils.isBlank(encryotTokenInRedis)) {
//            throw new AuthenticationException("token已经过期");
//        }
//
//
//        String account = JWTUtil.getAccount(token);
//
//        if(StringUtils.isBlank(account)) {
//            throw  new AuthenticationException("token校验不通过");
//        }

//        //通过用户名查询用户信息
//        User user = userManager.getUser(account);
//
//        if(user == null)
//            throw new AuthenticationException("用户名或密码错误");
//        if(!JWTUtil.verify(token, account, user.getPassword()))
//            throw new AuthenticationException("token校验不通过");

        return new SimpleAuthenticationInfo(token, token, "az_shiro_realm");

    }
}
