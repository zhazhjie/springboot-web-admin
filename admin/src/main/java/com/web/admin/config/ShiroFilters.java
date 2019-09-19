package com.web.admin.config;

import com.alibaba.fastjson.JSON;
import com.web.common.utils.ResponseData;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShiroFilters extends AuthenticatingFilter {

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest) request;
        //获取请求token
        String token = req.getHeader("token");
        if (StringUtils.isBlank(token)) {
            return null;
        }
        return new ShiroToken(token);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }

        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //获取请求token，如果token不存在，直接返回401
        String token = ((HttpServletRequest)request).getHeader("token");
        if (StringUtils.isBlank(token)) {
            HttpServletResponse httpResponse = setResponseHeaders(response);
            String json = JSON.toJSONString(ResponseData.fail(HttpStatus.UNAUTHORIZED.value(), "登录失效"));
            httpResponse.getWriter().print(json);
            return false;
        }
        return executeLogin(request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = setResponseHeaders(response);
        try {
            //处理登录失败的异常
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            int code;
            if (e instanceof LockedAccountException) {
                code = HttpStatus.FORBIDDEN.value();
            }else{
                code =HttpStatus.UNAUTHORIZED.value();
            }
            String json=JSON.toJSONString(ResponseData.fail(code, e.getMessage()));
            httpResponse.getWriter().print(json);
        } catch (IOException e1) { }

        return false;
    }

    private HttpServletResponse setResponseHeaders(ServletResponse response){
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        return httpResponse;
    }
}
