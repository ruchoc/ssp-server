package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.Share;
import edu.scau.pyx.ssp.entity.ShareListInfo;
import edu.scau.pyx.ssp.mapper.SensitiveKeywordMapper;
import edu.scau.pyx.ssp.mapper.ShareMapper;
import edu.scau.pyx.ssp.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private SensitiveKeywordMapper sensitiveKeywordMapper;

    @Override
    public long publish(Share share) {
        long matchNum = sensitiveKeywordMapper.match(share.getContent());
        if(matchNum!=0){
            return -1;
        }
        shareMapper.insertShare(share);
        return share.getId();
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

    @Override
    public List<ShareListInfo> getNewestShare(long begin, long length) {
        return shareMapper.getNewestShare(begin,length);
    }

    @Override
    public List<ShareListInfo> getFavoriteShare(long begin, long length) {
        return shareMapper.getFavoriteShare(begin,length);
    }
}
