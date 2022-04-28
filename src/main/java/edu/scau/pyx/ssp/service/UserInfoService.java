package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.UserInfo;

public interface UserInfoService {
    public boolean insertUserInfo(long userId);

    public UserInfo getUserInfo(long userId);

    public boolean updateUserInfo(UserInfo userInfo);
}
