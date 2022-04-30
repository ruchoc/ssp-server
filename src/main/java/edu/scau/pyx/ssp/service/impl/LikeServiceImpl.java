package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.Like;
import edu.scau.pyx.ssp.mapper.LikeMapper;
import edu.scau.pyx.ssp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeMapper likeMapper;

    @Override
    public boolean add(Like like) {
        return likeMapper.insert(like);
    }
}
