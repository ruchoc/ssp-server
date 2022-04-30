package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.Like;
import edu.scau.pyx.ssp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    @RequestMapping(value = "/add")
    public boolean add(@RequestBody Like like){
        return likeService.add(like);
    }
}
