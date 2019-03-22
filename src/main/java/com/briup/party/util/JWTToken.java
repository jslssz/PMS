package com.briup.party.util;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 封装数据交互的token对象
 */
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }
    //获得token中的密码和用户，使用jwtutil
    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
