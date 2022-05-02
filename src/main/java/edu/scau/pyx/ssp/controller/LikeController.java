package edu.scau.pyx.ssp.controller;

import com.mysql.cj.Session;
import edu.scau.pyx.ssp.entity.Like;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
