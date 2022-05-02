package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.Collect;
import edu.scau.pyx.ssp.entity.ShareListInfo;
import edu.scau.pyx.ssp.mapper.CollectMapper;
import edu.scau.pyx.ssp.mapper.ShareMapper;
import edu.scau.pyx.ssp.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private ShareMapper shareMapper;

    public boolean add(Collect collect){
        shareMapper.updateCollectNum(collect.getShareId());
        return collectMapper.insert(collect);
    }

    @Override
    public List<ShareListInfo> getCollectList(long userId) {
        return collectMapper.getCollectList(userId);
    }
}
