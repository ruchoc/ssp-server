package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.Share;
import edu.scau.pyx.ssp.entity.ShareListInfo;
import edu.scau.pyx.ssp.service.PictureService;
import edu.scau.pyx.ssp.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/share")
public class ShareController {
    @Autowired
    private ShareService shareService;

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public long publish(@RequestBody Share share){
        return shareService.publish(share);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ShareListInfo get(@RequestParam(value = "shareId", required = true) long shareId){
        return shareService.getShare(shareId);
    }

    @RequestMapping(value = "/getpublicsharelist", method = RequestMethod.GET)
    public List<ShareListInfo> getPublicShareList(@RequestParam long begin, @RequestParam long length){
        return shareService.getPublicShareList(begin,length);
    }

    @RequestMapping(value = "/getmysharelist", method = RequestMethod.GET)
    public List<ShareListInfo> getMyShareList(@RequestParam long userId, @RequestParam long begin, @RequestParam long length){
        return shareService.getMyShareList(userId,begin,length);
    }

    @RequestMapping(value = "/setsharestate", method = RequestMethod.GET)
    public boolean setShareState(@RequestParam long shareId, @RequestParam String state){
        return shareService.setShareState(shareId,state);
    }

    @RequestMapping(value = "/searchshare", method = RequestMethod.GET)
    public List<ShareListInfo> searchShare(@RequestParam String content){
        return shareService.searchShare(content);
    }

    @RequestMapping(value = "/deletepicture", method = RequestMethod.GET)
    public boolean deletePicture(@RequestParam long id){
        return pictureService.deletePicture(id);
    }

    @RequestMapping(value = "/updatecontent", method = RequestMethod.POST)
    public boolean updateContent(@RequestBody Share share){
        return shareService.updateContent(share);
    }
}
