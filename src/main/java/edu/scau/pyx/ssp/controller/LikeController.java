package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.Like;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserListInfo;
import edu.scau.pyx.ssp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @RequestMapping(value = "/add")
    public boolean add(@RequestBody Like like, HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null || !user.getRole().equals("user")){
            return false;
        }
        like.setUserId(user.getId());
        return likeService.add(like);
    }

    @RequestMapping(value = "/cancel/{shareId}",method = RequestMethod.DELETE)
    public boolean cancel(@PathVariable long shareId, HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user==null || !user.getRole().equals("user")){
            return false;
        }
        return likeService.cancel(shareId,user.getId());
    }

    @RequestMapping(value = "/getlist",method = RequestMethod.GET)
    public List<UserListInfo> getList(@RequestParam long shareId){
        return likeService.getList(shareId);
    }
}
