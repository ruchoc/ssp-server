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
}
