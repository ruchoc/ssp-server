package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.SensitiveKeyword;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserListInfo;
import edu.scau.pyx.ssp.service.SensitiveKeywordService;
import edu.scau.pyx.ssp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class AdministratorController {
    @Autowired
    private UserService userService;

    @Autowired
    private SensitiveKeywordService sensitiveKeywordService;

    @RequestMapping(value = "/updateuserlockstatus",method = RequestMethod.POST)
    public boolean updateUserLockStatus(@RequestBody SystemUser user){
        return userService.updateUserLocked(user.getId(),user.isLocked());
    }

    @RequestMapping(value = "/getsensitivekeyword", method = RequestMethod.GET)
    public List<SensitiveKeyword> getSensitiveKeyword(@RequestParam long begin, @RequestParam long length){
        return sensitiveKeywordService.getSensitiveKeyword(begin, length);
    }

    @RequestMapping(value = "/getsensitivekeywordnum", method = RequestMethod.GET)
    public long getSensitiveKeywordNum(){
        return sensitiveKeywordService.getSensitiveKeywordNum();
    }

    @RequestMapping(value = "/insertsensitivekeyword",method = RequestMethod.POST)
    public boolean insertSensitiveKeyword(@RequestBody Map<String,String> keywordMap){
        return sensitiveKeywordService.insertSensitiveKeyword(keywordMap.get("keyword"));
    }

    @RequestMapping(value = "/deletesensitivekeyword",method = RequestMethod.DELETE)
    public boolean deleteSensitiveKeyword(@RequestParam(value = "id",required = true) long id){
        return sensitiveKeywordService.deleteSensitiveKeyword(id);
    }

    @RequestMapping(value = "/getuserlist", method = RequestMethod.GET)
    public List<UserListInfo> getUserList(@RequestParam long begin, @RequestParam long length){
        return userService.getUserList(begin,length);
    }

    @RequestMapping(value = "/getusernum", method = RequestMethod.GET)
    public long getUserNum(){
        return userService.getUserNum();
    }
}
