package com.web.admin.config;

import org.apache.shiro.authc.AuthenticationToken;

public class ShiroToken implements AuthenticationToken {
    private static final long serialVersionUID = 1L;

    private String token;

    public ShiroToken(String token) {
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
