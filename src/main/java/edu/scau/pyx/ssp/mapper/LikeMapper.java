package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.Like;
import edu.scau.pyx.ssp.entity.UserListInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    public boolean delete(long shareId, long userId);

    public boolean insert(Like like);

    public int isLiked(long shareId, long userId);

    public List<UserListInfo> getList(long shareId);
}
