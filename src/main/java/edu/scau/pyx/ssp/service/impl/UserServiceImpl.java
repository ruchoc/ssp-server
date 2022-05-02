package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserListInfo;
import edu.scau.pyx.ssp.mapper.RoleMapper;
import edu.scau.pyx.ssp.mapper.UserMapper;
import edu.scau.pyx.ssp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean register(SystemUser systemUser) {
        encryptPassword(systemUser);
        userMapper.insertUser(systemUser);
        return roleMapper.insertUserAndRole(userMapper.getUserId(systemUser.getName()));
    }

    @Override
    public SystemUser getUser(long userId) {
        return userMapper.getUser(userId);
    }

    @Override
    public boolean updateUsername(long userId, String username) {
        return userMapper.updateUsername(userId, username);
    }

    @Override
    public boolean updateUserPassword(long userId, String password) {
        password = new BCryptPasswordEncoder().encode(password);
        return userMapper.updateUserPassword(userId, password);
    }

    @Override
    public boolean updateUserLocked(long userId, boolean isLocked) {
        return userMapper.updateUserLocked(userId, isLocked);
    }

    @Override
    public long getUserId(String username){
        return userMapper.getUserId(username);
    }

    @Override
    public List<UserListInfo> searchUser(String username) {
        StringBuffer sb = new StringBuffer("%");
        for(int i=0;i<username.length();i++){
            sb.append(username.charAt(i));
            sb.append('%');
        }
        username = sb.toString();
        return userMapper.searchUser(username);
    }


    private void encryptPassword(SystemUser systemUser){
        String password = systemUser.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        systemUser.setPassword(password);
    }
}
