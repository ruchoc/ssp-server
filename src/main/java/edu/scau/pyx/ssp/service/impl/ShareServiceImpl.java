package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.Share;
import edu.scau.pyx.ssp.entity.ShareListInfo;
import edu.scau.pyx.ssp.mapper.CollectMapper;
import edu.scau.pyx.ssp.mapper.LikeMapper;
import edu.scau.pyx.ssp.mapper.SensitiveKeywordMapper;
import edu.scau.pyx.ssp.mapper.ShareMapper;
import edu.scau.pyx.ssp.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private SensitiveKeywordMapper sensitiveKeywordMapper;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private LikeMapper likeMapper;
    @Autowired
    private CollectMapper collectMapper;

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
    public List<ShareListInfo> searchShare(String content,long begin,long length) {
        addHotSearch(content);
        StringBuilder sb = new StringBuilder("%");
        sb.append(content);
        sb.append("%");
        content = sb.toString();
        List<ShareListInfo> shareList = shareMapper.searchShare(content,begin,length);
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
        List<ShareListInfo> shareList = shareMapper.getNewestShare(begin,length);
        for(ShareListInfo shareListInfo : shareList){
            shareListInfo.setPictureList(shareMapper.getSharePictureList(shareListInfo.getId()));
        }
        return shareList;
    }

    @Override
    public List<ShareListInfo> getFavoriteShare(long begin, long length) {
        List<ShareListInfo> shareList = shareMapper.getFavoriteShare(begin,length);
        for(ShareListInfo shareListInfo : shareList){
            shareListInfo.setPictureList(shareMapper.getSharePictureList(shareListInfo.getId()));
        }
        return shareList;
    }

    @Override
    public boolean delete(long shareId) {
        return shareMapper.delete(shareId);
    }

    @Override
    public long getPublicShareNum() {
        return shareMapper.getPublicShareNum();
    }

    @Override
    public long getMyShareNum(long userId) {
        return shareMapper.getMyShareNum(userId);
    }
    //TODO
    @Override
    public void setLikeAndCollectState(ShareListInfo shareListInfo, long userId) {
        if(likeMapper.isLiked(shareListInfo.getId(), userId)==1){
            shareListInfo.setLiked(true);
        }
        if(collectMapper.isCollected(shareListInfo.getId(), userId)==1){
            shareListInfo.setCollected(true);
        }
    }
    //TODO
    @Override
    public void setLikeAndCollectState(List<ShareListInfo> shareListInfoList, long userId) {
        for(ShareListInfo shareListInfo : shareListInfoList){
            setLikeAndCollectState(shareListInfo, userId);
        }
    }

    @Override
    public long getSearchShareNum(String content) {
        StringBuilder sb = new StringBuilder("%");
        sb.append(content);
        sb.append("%");
        content = sb.toString();
        return shareMapper.getSearchShareNum(content);
    }

    private void addHotSearch(String hotSearch){
        Calendar tomorrow = Calendar.getInstance();
        tomorrow.add(Calendar.DATE,1);
        tomorrow.set(Calendar.HOUR_OF_DAY,0);
        tomorrow.set(Calendar.MINUTE,0);
        tomorrow.set(Calendar.SECOND,0);
        tomorrow.set(Calendar.MILLISECOND,0);
        long timeOut = (tomorrow.getTimeInMillis() - System.currentTimeMillis())/1000;
        redisTemplate.expire("hotSearchSet", timeOut, TimeUnit.SECONDS);
        redisTemplate.boundZSetOps("hotSearchSet").incrementScore(hotSearch,1);
    }
}
