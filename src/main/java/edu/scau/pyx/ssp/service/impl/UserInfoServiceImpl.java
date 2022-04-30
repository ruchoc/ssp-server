package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserInfo;
import edu.scau.pyx.ssp.mapper.UserInfoMapper;
import edu.scau.pyx.ssp.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean insertUserInfo(long userId) {
        return userInfoMapper.insertUserInfo(userId);
    }

    @Override
    public UserInfo getUserInfo(long userId) {
        return userInfoMapper.getUserInfo(userId);
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }

}
