package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.Collect;
import edu.scau.pyx.ssp.entity.ShareListInfo;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Collect collect,HttpSession session){
        collect.setUserId(((SystemUser)session.getAttribute("user")).getId());
        return collectService.add(collect);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<ShareListInfo> get(HttpSession session){
        return collectService.getCollectList(((SystemUser)session.getAttribute("user")).getId());
    }
}
