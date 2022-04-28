package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.mapper.SensitiveKeywordMapper;
import edu.scau.pyx.ssp.service.SensitiveKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensitiveKeywordServiceImpl implements SensitiveKeywordService {
    @Autowired
    private SensitiveKeywordMapper sensitiveKeywordMapper;

    @Override
    public boolean insertSensitiveKeyword(String keyword) {
        return sensitiveKeywordMapper.insertSensitiveKeyword(keyword);
    }

    @Override
    public boolean deleteSensitiveKeyword(long sensitiveKeywordId) {
        return sensitiveKeywordMapper.deleteSensitiveKeyword(sensitiveKeywordId);
    }
}
