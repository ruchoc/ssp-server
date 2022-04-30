package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserListInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public SystemUser getUserByUserName(String username);

    public SystemUser getUser(long userId);

    public boolean insertUser(SystemUser user);

    public boolean updateUsername(long userId, String username);

    public boolean updateUserPassword(long userId, String password);

    public boolean updateUserLocked(long userId, boolean isLocked);

    public long getUserId(String username);

    public List<UserListInfo> searchUser(String username);
}
