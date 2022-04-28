package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    public boolean insertUserInfo(long userId);

    public UserInfo getUserInfo(long userId);

    public boolean updateUserInfo(UserInfo userInfo);
}
