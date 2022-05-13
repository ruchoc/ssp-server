package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.Reply;
import edu.scau.pyx.ssp.entity.ReplyListInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public boolean insertReply(Reply reply);

    public List<ReplyListInfo> getReply(long commentId, long begin, long length);

    public long getReplyNum(long commmentId);
}
