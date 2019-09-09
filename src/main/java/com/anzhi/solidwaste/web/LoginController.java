package com.anzhi.solidwaste.web;

import com.anzhi.solidwaste.common.annotation.Limit;
import com.anzhi.solidwaste.common.authentication.JWTToken;
import com.anzhi.solidwaste.common.authentication.JWTUtil;
import com.anzhi.solidwaste.common.domain.ActiveUser;
import com.anzhi.solidwaste.common.domain.AzConstant;
import com.anzhi.solidwaste.common.exception.RedisConnectException;
import com.anzhi.solidwaste.common.properties.AzProperties;
import com.anzhi.solidwaste.common.response.AzResponse;
import com.anzhi.solidwaste.common.service.RedisService;
import com.anzhi.solidwaste.common.utils.AzUtil;
import com.anzhi.solidwaste.common.utils.DateUtil;
import com.anzhi.solidwaste.common.utils.IPUtil;
import com.anzhi.solidwaste.common.utils.MD5Util;
import com.anzhi.solidwaste.system.entity.User;
import com.anzhi.solidwaste.system.manager.UserManager;
import com.anzhi.solidwaste.system.service.UserService;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author anzhi
 * @date 2019/8/30 16:34
 */
@Api(tags = "登录")
@RestController
@RequestMapping("")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserManager userManager;

    @Autowired
    private AzProperties properties;

    @Autowired
    private ObjectMapper mapper;

    @ApiOperation(value = "登录身份验证（JWT验证）",notes="登陆")
    @PostMapping("/login")
    @Limit(key = "login", period = 60, count =20, name = "登录接口", prefix = "limit")
    public AzResponse login(
            @NotBlank(message = "{required}") String account,
            @NotBlank(message = "{required}") String password,
            HttpServletRequest request) throws Exception
    {
        account = StringUtils.lowerCase(account);
        password = MD5Util.encrypt(account, password);

        final String errorMessage = "用户名或密码错误";
        User user = this.userManager.getUser(account);

        if(user == null) {
            return new AzResponse(false,null,null, errorMessage);
        }
        if(!StringUtils.equals(user.getPassword(), password)){
            return new AzResponse(false,null,null, errorMessage);
        }
        if(User.STATUS_LOCK.equals(user.getIsActive())) {
            return new AzResponse(false, null, null, "账号已被锁定，请联系管理员！");
        }

        //更新用户登录时间
        //this.userService.updateLoginTime(account);

        //保存登录记录
//        TLoginLog loginLog = new TLoginLog();
//        loginLog.setAccount(account);
//        this.loginLogService.saveLoginLog(loginLog);

        String token = AzUtil.encryptToken(JWTUtil.sign(account, password));
        LocalDateTime expireTime = LocalDateTime.now().plusSeconds(properties.getShiro().getJwtTimeOut());
        String expireTimeStr = DateUtil.formatFullTime(expireTime);
        JWTToken jwtToken = new JWTToken(token, expireTimeStr);

        String userId = this.saveTokenToRedis(user, jwtToken,request);
        user.setUserId(userId);

        //Map<String, Object> userInfo = this.generateUserInfo(jwtToken, user);


        return new AzResponse(true, user, 200, "登录成功");
    }




    private String saveTokenToRedis(User user, JWTToken token, HttpServletRequest request) throws JsonProcessingException, RedisConnectException {
        String ip = IPUtil.getIpAddr(request);
        ActiveUser activeUser = new ActiveUser();
        activeUser.setAccount(user.getAccount());
        activeUser.setIp(ip);
        activeUser.setToken(token.getToken());
        //activeUser.setLoginAddress(AddressUtil.getCityInfo(DbSearcher.BTREE_ALGORITHM, ip));

        this.redisService.zadd(AzConstant.ACTIVE_USERS_ZSET_PREFIX, Double.valueOf(token.getExpireAt()), mapper.writeValueAsString(activeUser));
        this.redisService.set(AzConstant.TOKEN_CACHE_PREFIX + token.getToken() + StringPool.DOT + ip, token.getToken(), properties.getShiro().getJwtTimeOut()*1000);
        return activeUser.getId();
    }










    /**
     *  固废项目注册接口  分为人员注册 和 企业注册
     *
     *
     * @return
     */
    @GetMapping("/register/{}")
    public AzResponse register() {

        // 注册分为三种
        // 1.环保
        // 2.有企业
        // 3.无企业


        return null;
    }






}
