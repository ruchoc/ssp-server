package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.mapper.UserMapper;
import edu.scau.pyx.ssp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public long register(SystemUser systemUser) {
        encryptPassword(systemUser);
        return userMapper.insertUser(systemUser);
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


    private void encryptPassword(SystemUser systemUser){
        String password = systemUser.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        systemUser.setPassword(password);
    }
}
