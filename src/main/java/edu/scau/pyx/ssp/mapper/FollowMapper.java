package edu.scau.pyx.ssp.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowMapper {
    public boolean insertFollow(long fromUserId, long toUserId);
}
