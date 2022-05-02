package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.Role;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.Transient;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRoleService userRoleService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("loadUserByUsername");
        SystemUser systemUser = userRoleService.getUserByUsername(username);
        List<Role> roles = userRoleService.getRolesByUsername(username);
        return toUserDetails(systemUser,roles);
    }

    /**
     * 根据数据库的用户对象和其权限对象列表生成UserDetails类型的用户信息对象
     *
     * @param systemUser 数据库的用户对象
     * @param roles      用户的权限列表
     * @return UserDetails类型的用户信息对象
     */
    private UserDetails toUserDetails(SystemUser systemUser, List<Role> roles) {
        System.out.println("toUserDetails");
        if (systemUser == null) {
            return null;
        }
        List<GrantedAuthority> authorityList = new ArrayList<>(); // 权限列表
        for (Role role : roles) {
            System.out.println(role.getName());
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
            authorityList.add(authority);
        }
        UserDetails userDetails = new User(systemUser.getName(), systemUser.getPassword(), true,
                true, true, !systemUser.isLocked(), authorityList);
        return userDetails;
    }
}
