package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.Role;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.mapper.RoleMapper;
import edu.scau.pyx.ssp.mapper.UserMapper;
import edu.scau.pyx.ssp.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserMapper userMapper;
    private RoleMapper roleMapper;

    @Override
    public SystemUser getUserByUsername(String username) {
        return userMapper.getUserByUserName(username);
    }

    @Override
    public List<Role> getRolesByUsername(String username) {
        return roleMapper.getRolesByUserName(username);
    }
}
