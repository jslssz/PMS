package com.briup.party.component;

import com.briup.party.dao.UserMapper;
import com.briup.party.dao.extend.UserVMMapper;
import com.briup.party.util.JWTToken;
import com.briup.party.util.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserRealm extends AuthorizingRealm {
    private final UserMapper um;
    private final UserVMMapper uvmm;

    @Autowired
    public UserRealm(UserMapper um, UserVMMapper uvmm) {
        this.um = um;
        this.uvmm = uvmm;
    }
    /**
     * 必须重写此方法，不然会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证————");
        String token = (String) authenticationToken.getCredentials();
        String username = JWTUtil.getUsername(token);
        String password = um.getPassword(username);
//        这里不做密码比对判断，登录事时验证密码获取token，这里做token验证即可。
        if (username == null || !JWTUtil.verify(token, username,password)) {
            throw new AuthenticationException("token认证失败！"+"   用户"+username);
        }
        if (password == null) {
            throw new AuthenticationException("usernameError！");
        }
        return new SimpleAuthenticationInfo(token, token, "UserRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        String username = JWTUtil.getUsername(principalCollection.toString());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        String role = uvmm.getRole(username);
        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }
}
