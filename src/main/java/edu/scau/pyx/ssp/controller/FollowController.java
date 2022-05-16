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
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null || !user.getRole().equals("user")){
            return false;
        }
        follow.setFromUserId(user.getId());
        return followService.insertFollow(follow.getFromUserId(),follow.getToUserId());
    }

    @RequestMapping(value = "/cancel/{toUserId}", method = RequestMethod.DELETE)
    public boolean cancel(@PathVariable("toUserId") long toUserId, HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null || !user.getRole().equals("user")){
            return false;
        }
        return followService.deleteFollow(user.getId(),toUserId);
    }

    @RequestMapping(value = "/getfollowinguser", method = RequestMethod.GET)
    public List<UserListInfo> getFollowingUser(HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null || !user.getRole().equals("user")){
            return null;
        }
        return followService.getFollowingUser(user.getId());
    }

    @RequestMapping(value = "/getfans", method = RequestMethod.GET)
    public List<UserListInfo> getFans(HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null || !user.getRole().equals("user")){
            return null;
        }
        return followService.getFans(user.getId());
    }
}
