package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.Share;
import edu.scau.pyx.ssp.entity.ShareListInfo;

import java.util.List;

public interface ShareService {
    public long publish(Share share);

    public ShareListInfo getShare(long shareId);

    public List<ShareListInfo> getPublicShareList(long begin, long length);

    public List<ShareListInfo> getMyShareList(long userId, long begin, long length);

    public boolean setShareState(long shareId, String state);

    public List<ShareListInfo> searchShare(String content,long begin,long length);

    public boolean updateContent(Share share);

    public List<ShareListInfo> getNewestShare(long begin, long length);

    public List<ShareListInfo> getFavoriteShare(long begin, long length);

    public boolean delete(long shareId);

    public long getPublicShareNum();

    public long getMyShareNum(long userId);

    public void setLikeAndCollectState(ShareListInfo shareListInfo, long userId);

    public void setLikeAndCollectState(List<ShareListInfo> shareListInfoList, long userId);

    public long getSearchShareNum(String content);
}
