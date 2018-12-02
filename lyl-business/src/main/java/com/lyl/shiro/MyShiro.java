package com.lyl.shiro;

import com.lyl.dao.PermissionDAO;
import com.lyl.dao.RoleDAO;
import com.lyl.dao.UserDAO;
import com.lyl.ensure.Ensure;
import com.lyl.pojo.User;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lyl on 2016/9/15.
 */
public class MyShiro extends AuthorizingRealm {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PermissionDAO permissionDAO;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String)principalCollection.fromRealm(getName()).iterator().next();
        User user = userDAO.findByName(username);
        Ensure.that(user).isNotNull("S_SHIERO_0001");
        List<String> rolenameList = roleDAO.findRolesByUsername(user.getUsername());
        Set<String> permissionSet = getRolePermissionMapByUsername(rolenameList);

        SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();
        simpleAuthenticationInfo.addRoles(rolenameList);
        simpleAuthenticationInfo.addStringPermissions(permissionSet);

        return simpleAuthenticationInfo;
    }

    /** 通过用户名获取角色权限对应MAp */
    private Set<String> getRolePermissionMapByUsername(List<String> rolenameList){
        Set<String> permissionSet = new HashSet<String>();
        if (!CollectionUtils.isEmpty(rolenameList)){
            for (String rolename : rolenameList){
                List<String> permissionList = permissionDAO.findPermissionsByRolename(rolename);
                for (String permission : permissionList){
                    permissionSet.add(permission);
                }
            }
        }
        return permissionSet;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println("验证当前Subject获取到的token：" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE));
        User user = userDAO.findByName(token.getUsername());
        if (null != user){
            SimpleAuthenticationInfo authorizationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),getName());
            return authorizationInfo;
        }
        return null;
    }

}
