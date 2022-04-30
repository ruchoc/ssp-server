package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.Follow;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserListInfo;
import edu.scau.pyx.ssp.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/follow")
public class FollowController {
    @Autowired
    private FollowService followService;

    @RequestMapping(value = "/follow", method = RequestMethod.POST)
    public boolean follow(@RequestBody Follow follow){
        return followService.insertFollow(follow.getFromUserId(),follow.getToUserId());
    }

    @RequestMapping(value = "/getfollowinguser", method = RequestMethod.GET)
    public List<UserListInfo> getFollowingUser(long userId){
        return followService.getFollowingUser(userId);
    }

    @RequestMapping(value = "/getfans", method = RequestMethod.GET)
    public List<UserListInfo> getFans(long userId){
        return followService.getFans(userId);
    }
}
