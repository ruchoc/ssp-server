package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.CommentListInfo;
import edu.scau.pyx.ssp.entity.Reply;
import edu.scau.pyx.ssp.entity.ReplyListInfo;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/reply")
public class ReplyController {
    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public boolean publish(@RequestBody Reply reply, HttpSession session){
        reply.setSendUserId(((SystemUser)session.getAttribute("user")).getId());
        return replyService.publishReply(reply);
    }

    @RequestMapping(value = "/getreply", method = RequestMethod.GET)
    public List<ReplyListInfo> getReply(@RequestParam long commentId, @RequestParam long begin, @RequestParam long length){
        return replyService.getReply(commentId,begin,length);
    }

    @RequestMapping(value = "/getreplynum", method = RequestMethod.GET)
    public long getReplyNum(@RequestParam long commentId){
        return replyService.getReplyNum(commentId);
    }
}
