package edu.scau.pyx.ssp.controller;

import com.mysql.cj.Session;
import edu.scau.pyx.ssp.entity.Like;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @RequestMapping(value = "/add")
    public boolean add(@RequestBody Like like, HttpSession session){
        like.setUserId(((SystemUser)session.getAttribute("user")).getId());
        return likeService.add(like);
    }

    @RequestMapping(value = "/cancel/{shareId}",method = RequestMethod.DELETE)
    public boolean cancel(@PathVariable long shareId, HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user==null){
            return false;
        }
        return likeService.cancel(shareId,user.getId());
    }
}
