package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.Share;
import edu.scau.pyx.ssp.entity.ShareListInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShareMapper {
    public long insertShare(Share share);

    public ShareListInfo getShare(long shareId);

    public List<ShareListInfo> getPublicShareList(long begin, long length);

    public List<String> getSharePictureList(long shareId);

    public List<ShareListInfo> getMyShareList(long userId, long begin, long length);

    public boolean updateShareState(long shareId, String state);
}
