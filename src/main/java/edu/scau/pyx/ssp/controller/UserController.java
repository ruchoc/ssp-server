package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.Follow;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserInfo;
import edu.scau.pyx.ssp.service.FollowService;
import edu.scau.pyx.ssp.service.UserInfoService;
import edu.scau.pyx.ssp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private FollowService followService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public boolean registerUser(@RequestBody SystemUser user){
        return userInfoService.insertUserInfo(userService.register(user));
    }

    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public SystemUser getUser(@RequestParam(value = "userId", required = true) long userId){
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/getuserinfo",method = RequestMethod.GET)
    public UserInfo getUserInfo(@RequestParam(value = "userId", required = true) long userId){
        return userInfoService.getUserInfo(userId);
    }

    @RequestMapping(value = "/updateusername",method = RequestMethod.POST)
    public boolean updateUsername(@RequestBody SystemUser user){
        return userService.updateUsername(user.getId(), user.getName());
    }

    @RequestMapping(value = "/updateuserpassword",method = RequestMethod.POST)
    public boolean updateUserPassword(@RequestBody SystemUser user){
        return userService.updateUserPassword(user.getId(), user.getPassword());
    }

    @RequestMapping(value = "/updateuserinfo",method = RequestMethod.POST)
    public boolean updateUserInfo(@RequestBody UserInfo userInfo){
        return userInfoService.updateUserInfo(userInfo);
    }

    @RequestMapping(value = "/follow", method = RequestMethod.POST)
    public boolean follow(@RequestBody Follow follow){
        return followService.insertFollow(follow.getFromUserId(),follow.getToUserId());
    }
}
