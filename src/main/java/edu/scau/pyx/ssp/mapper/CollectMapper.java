package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.Collect;
import edu.scau.pyx.ssp.entity.ShareListInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CollectMapper {
    public boolean insert(Collect collect);

    public List<ShareListInfo> getCollectList(long userId);

    public int isCollected(long shareId, long userId);

    public boolean delete(long shareId, long userId);
}
