package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserListInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FollowMapper {
    public boolean insertFollow(long fromUserId, long toUserId);

    public List<UserListInfo> getFollowingUser(long userId);

    public List<UserListInfo> getFans(long userId);
}
