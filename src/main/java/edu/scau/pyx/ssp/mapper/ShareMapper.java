package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.Picture;
import edu.scau.pyx.ssp.entity.Share;
import edu.scau.pyx.ssp.entity.ShareListInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShareMapper {
    public long insertShare(Share share);

    public ShareListInfo getShare(long shareId);

    public List<ShareListInfo> getPublicShareList(long begin, long length);

    public List<Picture> getSharePictureList(long shareId);

    public List<ShareListInfo> getMyShareList(long userId, long begin, long length);

    public boolean updateShareState(long shareId, String state);

    public List<ShareListInfo> searchShare(String content);

    boolean updateContent(String content, long id);

    public List<ShareListInfo> getNewestShare(long begin, long length);

    public List<ShareListInfo> getFavoriteShare(long begin, long length);

    public boolean increaseLikeNum(long id);

    public boolean decreaseLikeNum(long id);

    public boolean updateCollectNum(long id);

    public boolean updateCommentNum(long id);

    public boolean delete(long shareId);

    public long getPublicShareNum();

    public long getMyShareNum(long userId);
}
