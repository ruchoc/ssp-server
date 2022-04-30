package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.Comment;
import edu.scau.pyx.ssp.entity.CommentListInfo;

import java.util.List;

public interface CommentService {
    public boolean publishComment(Comment comment);

    public List<CommentListInfo> getComment(long shareId, long begin, long length);
}
