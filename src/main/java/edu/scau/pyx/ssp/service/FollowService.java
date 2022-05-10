package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserListInfo;

import java.util.List;

public interface FollowService {
    public boolean insertFollow(long fromUserId, long toUserId);

    public List<UserListInfo> getFollowingUser(long userId);

    public List<UserListInfo> getFans(long userId);

    public boolean deleteFollow(long fromUserId, long toUserId);
}
