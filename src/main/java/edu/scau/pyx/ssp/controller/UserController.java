package edu.scau.pyx.ssp.controller;

import com.sun.deploy.net.HttpResponse;
import edu.scau.pyx.ssp.entity.Follow;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserInfo;
import edu.scau.pyx.ssp.entity.UserListInfo;
import edu.scau.pyx.ssp.service.FollowService;
import edu.scau.pyx.ssp.service.UserInfoService;
import edu.scau.pyx.ssp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.util.List;

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
        userService.register(user);
        return userInfoService.insertUserInfo(userService.getUserId(user.getName()));
    }

    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public boolean signIn(@RequestBody SystemUser user, HttpSession session){
        return userService.signIn(user,session);
    }

    @RequestMapping(value = "/signout",method = RequestMethod.POST)
    public String signOut(HttpSession session, HttpServletResponse response){
        session.removeAttribute("user");
        Cookie cookie = new Cookie("jsessionid",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "sign out";
    }

    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public SystemUser getUser(@RequestParam(value = "userId", required = true) long userId){
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/getuserinfo",method = RequestMethod.GET)
    public UserInfo getUserInfo(@RequestParam(value = "userId", required = true) long userId){
        return userInfoService.getUserInfo(userId);
    }

    @RequestMapping(value = "/getcurrentuser",method = RequestMethod.GET)
    public SystemUser getUser(HttpSession session){
        SystemUser user = ((SystemUser) session.getAttribute("user"));
        if(user == null){
            return null;
        }
        return userService.getUser(user.getId());
    }

    @RequestMapping(value = "/getcurrentuserinfo",method = RequestMethod.GET)
    public UserInfo getUserInfo(HttpSession session){
        SystemUser user = ((SystemUser) session.getAttribute("user"));
        if(user == null){
            return null;
        }
        return userInfoService.getUserInfo(user.getId());
    }

    @RequestMapping(value = "/updateusername",method = RequestMethod.POST)
    public boolean updateUsername(@RequestBody SystemUser user,HttpSession session){
        return userService.updateUsername(((SystemUser)session.getAttribute("user")).getId(), user.getName());
    }

    @RequestMapping(value = "/updateuserpassword",method = RequestMethod.POST)
    public boolean updateUserPassword(@RequestBody SystemUser user,HttpSession session){
        return userService.updateUserPassword(((SystemUser)session.getAttribute("user")).getId(), user.getPassword());
    }

    @RequestMapping(value = "/updateuserinfo",method = RequestMethod.POST)
    public boolean updateUserInfo(@RequestBody UserInfo userInfo,HttpSession session){
        userInfo.setUserId(((SystemUser)session.getAttribute("user")).getId());
        return userInfoService.updateUserInfo(userInfo);
    }

    @RequestMapping(value = "/searchuser" ,method = RequestMethod.GET)
    public List<UserListInfo> searchUser(@RequestParam String username){
        return userService.searchUser(username);
    }
}
