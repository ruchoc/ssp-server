package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.Comment;
import edu.scau.pyx.ssp.entity.CommentListInfo;
import edu.scau.pyx.ssp.mapper.CommentMapper;
import edu.scau.pyx.ssp.mapper.ShareMapper;
import edu.scau.pyx.ssp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ShareMapper shareMapper;

    @Override
    public boolean publishComment(Comment comment) {
        shareMapper.updateCommentNum(comment.getShareId());
        return commentMapper.insertComment(comment);
    }

    @Override
    public List<CommentListInfo> getComment(long shareId, long begin, long length) {
        return commentMapper.getComment(shareId,begin,length);
    }

    @Override
    public long getCommentNum(long shareId) {
        return commentMapper.getCommentNum(shareId);
    }
}
