package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.Share;
import edu.scau.pyx.ssp.entity.ShareListInfo;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.service.PictureService;
import edu.scau.pyx.ssp.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/share")
public class ShareController {
    @Autowired
    private ShareService shareService;

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    public long publish(@RequestBody Share share, HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null || !user.getRole().equals("user")){
            return -1;
        }
        if(user.isLocked()){
            return -1;
        }
        share.setUserId(user.getId());
        return shareService.publish(share);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ShareListInfo get(@RequestParam(value = "shareId", required = true) long shareId, HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        ShareListInfo shareListInfo =  shareService.getShare(shareId);
        if(user != null){
            shareService.setLikeAndCollectState(shareListInfo, user.getId());
        }
        return shareListInfo;

    }

    @RequestMapping(value = "/getpublicsharelist", method = RequestMethod.GET)
    public List<ShareListInfo> getPublicShareList(@RequestParam long begin, @RequestParam long length, HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        List<ShareListInfo> shareListInfoList = shareService.getPublicShareList(begin,length);
        if(user != null){
            shareService.setLikeAndCollectState(shareListInfoList, user.getId());
        }
        return shareListInfoList;
    }

    @RequestMapping(value = "/getmysharelist", method = RequestMethod.GET)
    public List<ShareListInfo> getMyShareList(HttpSession session,@RequestParam long begin, @RequestParam long length){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null || !user.getRole().equals("user")){
            return null;
        }
        List<ShareListInfo> shareListInfoList = shareService.getMyShareList(((SystemUser)session.getAttribute("user")).getId(),begin,length);
        shareService.setLikeAndCollectState(shareListInfoList, user.getId());
        return shareListInfoList;
    }

    @RequestMapping(value = "/getnewestshare", method = RequestMethod.GET)
    public List<ShareListInfo> getNewestShare(@RequestParam long begin, @RequestParam long length, HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        List<ShareListInfo> shareListInfoList = shareService.getNewestShare(begin,length);
        if(user != null){
            shareService.setLikeAndCollectState(shareListInfoList, user.getId());
        }
        return shareListInfoList;
    }

    @RequestMapping(value = "/getfavoriteshare", method = RequestMethod.GET)
    public List<ShareListInfo> getFavoriteShare(@RequestParam long begin, @RequestParam long length, HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        List<ShareListInfo> shareListInfoList = shareService.getFavoriteShare(begin,length);
        if(user != null){
            shareService.setLikeAndCollectState(shareListInfoList, user.getId());
        }
        return shareListInfoList;
    }

    @RequestMapping(value = "/setsharestate", method = RequestMethod.GET)
    public boolean setShareState(@RequestParam long shareId, @RequestParam String state){
        return shareService.setShareState(shareId,state);
    }

    @RequestMapping(value = "/searchshare", method = RequestMethod.GET)
    public List<ShareListInfo> searchShare(@RequestParam String content, @RequestParam long begin, @RequestParam long length, HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        List<ShareListInfo> shareListInfoList = shareService.searchShare(content,begin,length);
        if(user != null){
            shareService.setLikeAndCollectState(shareListInfoList, user.getId());
        }
        return shareListInfoList;
    }

    @RequestMapping(value = "getsearchsharenum", method = RequestMethod.GET)
    public long getSearchShareNum(@RequestParam String content){
        return shareService.getSearchShareNum(content);
    }

    @RequestMapping(value = "/deletepicture", method = RequestMethod.GET)
    public boolean deletePicture(@RequestParam long id){
        return pictureService.deletePicture(id);
    }

    @RequestMapping(value = "/updatecontent", method = RequestMethod.POST)
    public boolean updateContent(@RequestBody Share share){
        return shareService.updateContent(share);
    }

    @RequestMapping(value = "/delete/{shareId}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("shareId") long shareId){
        return shareService.delete(shareId);
    }

    @RequestMapping(value = "/getpublicsharenum", method = RequestMethod.GET)
    public long getPublicShareNum(){
        return shareService.getPublicShareNum();
    }

    @RequestMapping(value = "/getmysharenum", method = RequestMethod.GET)
    public long getMyShareNum(HttpSession session){
        SystemUser user = (SystemUser) session.getAttribute("user");
        if(user == null || !user.getRole().equals("user")){
            return 0;
        }
        return shareService.getMyShareNum(user.getId());
    }
}
