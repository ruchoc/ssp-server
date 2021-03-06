package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.Comment;
import edu.scau.pyx.ssp.entity.CommentListInfo;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public boolean publish(@RequestBody Comment comment, HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null || !user.getRole().equals("user")){
            return false;
        }
        comment.setUserId(user.getId());
        return commentService.publishComment(comment);
    }

    @RequestMapping(value = "/getcomment", method = RequestMethod.GET)
    public List<CommentListInfo> getComment(@RequestParam long shareId, @RequestParam long begin, @RequestParam long length){
        return commentService.getComment(shareId,begin,length);
    }

    @RequestMapping(value = "/getcommentnum", method = RequestMethod.GET)
    public long getCommentNum(@RequestParam long shareId){
        return commentService.getCommentNum(shareId);
    }
}