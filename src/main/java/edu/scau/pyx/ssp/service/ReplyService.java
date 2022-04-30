package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.Reply;
import edu.scau.pyx.ssp.entity.ReplyListInfo;

import java.util.List;

public interface ReplyService {
    public boolean publishReply(Reply reply);

    public List<ReplyListInfo>  getReply(long commentId, long begin, long length);
}
