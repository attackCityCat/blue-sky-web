package org.bs.web.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.bs.web.pojo.UserBean;
import org.bs.web.service.llp.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceApi userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("执行认证逻辑");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        UserBean userBean = userService.findByPhone(token.getUsername());
        if (userBean == null){
            return null;
        }
        return new SimpleAuthenticationInfo(userBean,userBean.getPassword(),this.getClass().getName());
    }

}
