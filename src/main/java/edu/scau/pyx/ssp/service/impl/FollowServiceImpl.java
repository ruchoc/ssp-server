package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.mapper.FollowMapper;
import edu.scau.pyx.ssp.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowMapper followMapper;

    @Override
    public boolean insertFollow(long fromUserId, long toUserId) {
        return followMapper.insertFollow(fromUserId,toUserId);
    }
}
