package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.HotSearch;
import edu.scau.pyx.ssp.service.HotSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class HotSearchServiceImpl implements HotSearchService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public List<HotSearch> getList() {
        List<HotSearch> hotSearchList = new ArrayList<>();
        Set<String> hotSearchSet = redisTemplate.opsForZSet().reverseRange("hotSearchSet", 0, 9);
        Iterator<String> iterator = hotSearchSet.iterator();
        while (iterator.hasNext()){
            String hotSearch = (String) iterator.next();
            long times = redisTemplate.opsForZSet().score("hotSearchSet",hotSearch).longValue();
            hotSearchList.add(new HotSearch(hotSearch,times));
        }
        return hotSearchList;
    }
}
