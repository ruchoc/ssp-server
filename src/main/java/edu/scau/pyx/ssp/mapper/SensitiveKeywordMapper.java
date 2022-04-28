package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.SensitiveKeyword;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SensitiveKeywordMapper {
    public boolean insertSensitiveKeyword(String keyword);

    public boolean deleteSensitiveKeyword(long sensitiveKeywordId);
}
