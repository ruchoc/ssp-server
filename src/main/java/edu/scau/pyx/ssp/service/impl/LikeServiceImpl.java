package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.Like;
import edu.scau.pyx.ssp.mapper.LikeMapper;
import edu.scau.pyx.ssp.mapper.ShareMapper;
import edu.scau.pyx.ssp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;
    @Autowired
    private ShareMapper shareMapper;

    @Override
    public boolean add(Like like) {
        shareMapper.increaseLikeNum(like.getShareId());
        return likeMapper.insert(like);
    }

    @Override
    public boolean cancel(long shareId, long userId) {
        shareMapper.decreaseLikeNum(shareId);
        return likeMapper.delete(shareId,userId);
    }
}
