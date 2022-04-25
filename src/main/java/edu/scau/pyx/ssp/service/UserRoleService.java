package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.Role;
import edu.scau.pyx.ssp.entity.SystemUser;

import java.util.List;

public interface UserRoleService {
    public SystemUser getUserByUsername(String username);

    public List<Role> getRolesByUsername(String username);
}