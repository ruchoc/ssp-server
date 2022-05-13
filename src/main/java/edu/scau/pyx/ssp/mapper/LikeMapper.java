package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.Like;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {
    public boolean delete(long shareId, long userId);

    public boolean insert(Like like);
}
