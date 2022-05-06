package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.SensitiveKeyword;
import edu.scau.pyx.ssp.mapper.SensitiveKeywordMapper;
import edu.scau.pyx.ssp.service.SensitiveKeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensitiveKeywordServiceImpl implements SensitiveKeywordService {
    @Autowired
    private SensitiveKeywordMapper sensitiveKeywordMapper;

    @Override
    public boolean insertSensitiveKeyword(String keyword) {
        StringBuffer sb = new StringBuffer("%");
        sb.append(keyword);
        sb.append("%");
        keyword = sb.toString();
        return sensitiveKeywordMapper.insertSensitiveKeyword(keyword);
    }

    @Override
    public boolean deleteSensitiveKeyword(long sensitiveKeywordId) {
        return sensitiveKeywordMapper.deleteSensitiveKeyword(sensitiveKeywordId);
    }

    @Override
    public List<SensitiveKeyword> getSensitiveKeyword(long begin, long length) {
        List<SensitiveKeyword> sensitiveKeywordList = sensitiveKeywordMapper.getSensitiveKeyword(begin, length);
        for(SensitiveKeyword sensitiveKeyword : sensitiveKeywordList){
            String keyword = sensitiveKeyword.getKeyword();
            sensitiveKeyword.setKeyword(keyword.substring(1,keyword.length()-1));
        }
        return sensitiveKeywordList;
    }
}
