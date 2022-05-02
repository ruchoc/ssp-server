package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.Share;
import edu.scau.pyx.ssp.entity.ShareListInfo;
import edu.scau.pyx.ssp.mapper.ShareMapper;
import edu.scau.pyx.ssp.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;

    @Override
    public long publish(Share share) {
        return shareMapper.insertShare(share);
    }

    @Override
    public ShareListInfo getShare(long shareId) {
        ShareListInfo shareListInfo = shareMapper.getShare(shareId);
        shareListInfo.setPictureList(shareMapper.getSharePictureList(shareListInfo.getId()));
        return shareListInfo;
    }

    @Override
    public List<ShareListInfo> getPublicShareList(long begin, long length) {
        List<ShareListInfo> shareList = shareMapper.getPublicShareList(begin,length);
        for(ShareListInfo shareListInfo : shareList){
            shareListInfo.setPictureList(shareMapper.getSharePictureList(shareListInfo.getId()));
        }
        return shareList;
    }

    @Override
    public List<ShareListInfo> getMyShareList(long userId, long begin, long length) {
        List<ShareListInfo> shareList = shareMapper.getMyShareList(userId,begin,length);
        for(ShareListInfo shareListInfo : shareList){
            shareListInfo.setPictureList(shareMapper.getSharePictureList(shareListInfo.getId()));
        }
        return shareList;
    }

    @Override
    public boolean setShareState(long shareId, String state) {
        return shareMapper.updateShareState(shareId,state);
    }

    @Override
    public List<ShareListInfo> searchShare(String content) {
        StringBuffer sb = new StringBuffer("%");
        sb.append(content);
        sb.append("%");
        content = sb.toString();
        List<ShareListInfo> shareList = shareMapper.searchShare(content);
        for(ShareListInfo shareListInfo : shareList){
            shareListInfo.setPictureList(shareMapper.getSharePictureList(shareListInfo.getId()));
        }
        return shareList;
    }

    @Override
    public boolean updateContent(Share share) {
        return shareMapper.updateContent(share.getContent(),share.getId());
    }
}
