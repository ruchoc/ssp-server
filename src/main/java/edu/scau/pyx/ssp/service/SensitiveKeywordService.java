package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.SensitiveKeyword;

import java.util.List;

public interface SensitiveKeywordService {
    public boolean insertSensitiveKeyword(String keyword);

    public boolean deleteSensitiveKeyword(long sensitiveKeywordId);

    public List<SensitiveKeyword> getSensitiveKeyword(long begin, long length);

    public long getSensitiveKeywordNum();
}
