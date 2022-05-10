package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.Follow;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserListInfo;
import edu.scau.pyx.ssp.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/follow")
public class FollowController {
    @Autowired
    private FollowService followService;

    @RequestMapping(value = "/follow", method = RequestMethod.POST)
    public boolean follow(@RequestBody Follow follow, HttpSession session){
        follow.setFromUserId(((SystemUser)session.getAttribute("user")).getId());
        return followService.insertFollow(follow.getFromUserId(),follow.getToUserId());
    }

    @RequestMapping(value = "/cancel/{toUserId}", method = RequestMethod.DELETE)
    public boolean cancel(@PathVariable("toUserId") long toUserId, HttpSession session){
        return followService.deleteFollow(((SystemUser)session.getAttribute("user")).getId(),toUserId);
    }

    @RequestMapping(value = "/getfollowinguser", method = RequestMethod.GET)
    public List<UserListInfo> getFollowingUser(HttpSession session){
        return followService.getFollowingUser(((SystemUser)session.getAttribute("user")).getId());
    }

    @RequestMapping(value = "/getfans", method = RequestMethod.GET)
    public List<UserListInfo> getFans(HttpSession session){
        return followService.getFans(((SystemUser)session.getAttribute("user")).getId());
    }
}
