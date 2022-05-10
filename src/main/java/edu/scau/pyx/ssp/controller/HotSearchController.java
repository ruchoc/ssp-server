package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.HotSearch;
import edu.scau.pyx.ssp.service.HotSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotsearch")
public class HotSearchController {
    @Autowired
    private HotSearchService hotSearchService;

    @RequestMapping(value = "/getlist", method = RequestMethod.GET)
    public List<HotSearch> getList(){
        return hotSearchService.getList();
    }
}
