package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.Collect;
import edu.scau.pyx.ssp.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean add(@RequestBody Collect collect){
        return collectService.add(collect);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Collect> get(@RequestParam long userId){
        return collectService.getCollectList(userId);
    }
}
