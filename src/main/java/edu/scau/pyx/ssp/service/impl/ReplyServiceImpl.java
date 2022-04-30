package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.Reply;
import edu.scau.pyx.ssp.entity.ReplyListInfo;
import edu.scau.pyx.ssp.mapper.ReplyMapper;
import edu.scau.pyx.ssp.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;
    @Override
    public boolean publishReply(Reply reply) {
        return replyMapper.insertReply(reply);
    }

    @Override
    public List<ReplyListInfo> getReply(long commentId, long begin, long length) {
        return replyMapper.getReply(commentId,begin,length);
    }
}
