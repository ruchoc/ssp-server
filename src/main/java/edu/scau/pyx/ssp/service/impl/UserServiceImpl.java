package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.mapper.UserMapper;
import edu.scau.pyx.ssp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(SystemUser systemUser) {
        encryptPassword(systemUser);
        return userMapper.insertUser(systemUser);
    }

    private void encryptPassword(SystemUser systemUser){
        String password = systemUser.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        systemUser.setPassword(password);
    }
}
