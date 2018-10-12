package com.springboot.shiro;

import com.springboot.model.Role;
import com.springboot.model.User;
import com.springboot.service.ResService;
import com.springboot.service.RoleService;
import com.springboot.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private ResService resService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("==================================");
        System.out.println("授权操作");
        System.out.println("==================================");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        User user = (User) principals.getPrimaryPrincipal();
        user = userService.findByName(user.getName());

        if(user.getRoleId() == null) {
            info.addRole("guest");
        } else {
            System.out.println(user.getRoleId());
            Role role = roleService.findById(user.getRoleId());
            info.addRole(role.getRoleName());

            List<String> permissions = resService.findAllResNameByRoleId(role.getId());

            info.addStringPermissions(permissions);
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("==================================");
        System.out.println("登录操作");
        System.out.println("==================================");

        String name = (String) token.getPrincipal();
        User user = userService.findByName(name);
        if(user == null) {
            throw new UnknownAccountException("账号不存在");
        }

        AuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), this.getName());
        return info;
    }
}
