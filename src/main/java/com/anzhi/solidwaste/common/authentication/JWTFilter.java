package com.anzhi.solidwaste.common.authentication;


import com.anzhi.solidwaste.common.properties.AzProperties;
import com.anzhi.solidwaste.common.utils.AzUtil;
import com.anzhi.solidwaste.common.utils.SpringContextUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author andy
 * @date 2019/7/1 9:38
 */
@Slf4j
public class JWTFilter extends BasicHttpAuthenticationFilter {


    private static final String TOKEN = "token";

    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws UnauthorizedException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        AzProperties azProperties = SpringContextUtil.getBean(AzProperties.class);

        String[] anonUrl = StringUtils.splitByWholeSeparatorPreserveAllTokens(azProperties.getShiro().getAnonUrl(), StringPool.COMMA);

        List<String> anonUrlList = Arrays.asList(anonUrl);
        List<String> list = new ArrayList<>(anonUrlList);

        //  放行 swagger2


        boolean match = false;
        for(String u: list){
            System.out.println("进来的PATH ： " + httpServletRequest.getRequestURI());
            if(pathMatcher.match(u, httpServletRequest.getRequestURI())) {
                log.info("认证PATH ： " + httpServletRequest.getRequestURI() + "   ------");
                System.out.println();
                match = true;
            }
        }
        if(match){
            return true;
        }
        if(isLoginAttempt(request, response)){
            try {
                return executeLogin(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader(TOKEN);
        return token != null;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader(TOKEN);
        JWTToken jwtToken = new JWTToken(AzUtil.decryptToken(token));
        try{
            getSubject(request, response).login(jwtToken);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
    
    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个 option 请求，这里我们给 option 请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }

    @Override
    protected boolean sendChallenge(ServletRequest request, ServletResponse response) {
        log.debug("Authentication required: sending 401 Authentication challenge response.");
        HttpServletResponse httpResponse = WebUtils.toHttp(response);
        httpResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpResponse.setCharacterEncoding("utf-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        final String message = "未认证，请在前端系统进行认证";
        try (PrintWriter out = httpResponse.getWriter()) {
            String responseJson = "{\"message\":\"" + message + "\"}";
            out.print(responseJson);
        } catch (IOException e) {
            log.error("sendChallenge error：", e);
        }
        return false;
    }
    
}
