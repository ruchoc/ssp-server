package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.Comment;
import edu.scau.pyx.ssp.entity.CommentListInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    public boolean insertComment(Comment comment);

    public List<CommentListInfo> getComment(long shareId, long begin, long length);
}
