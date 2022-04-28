package edu.scau.pyx.ssp.service;

public interface SensitiveKeywordService {
    public boolean insertSensitiveKeyword(String keyword);

    public boolean deleteSensitiveKeyword(long sensitiveKeywordId);
}
