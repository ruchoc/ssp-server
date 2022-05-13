package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.SensitiveKeyword;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SensitiveKeywordMapper {
    public boolean insertSensitiveKeyword(String keyword);

    public boolean deleteSensitiveKeyword(long sensitiveKeywordId);

    public long match(String content);

    public List<SensitiveKeyword> getSensitiveKeyword(long begin, long length);

    public long getSensitiveKeywordNum();
}
