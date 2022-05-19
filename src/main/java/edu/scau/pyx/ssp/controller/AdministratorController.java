package edu.scau.pyx.ssp.controller;

import edu.scau.pyx.ssp.entity.SensitiveKeyword;
import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserListInfo;
import edu.scau.pyx.ssp.service.SensitiveKeywordService;
import edu.scau.pyx.ssp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/admin")
public class AdministratorController {
    @Autowired
    private UserService userService;

    @Autowired
    private SensitiveKeywordService sensitiveKeywordService;

    @RequestMapping(value = "/signin",method = RequestMethod.POST)
    public boolean signIn(@RequestBody SystemUser user, HttpSession session){
        return userService.adminSignIn(user,session);
    }

    @RequestMapping(value = "/updateuserlockstatus",method = RequestMethod.POST)
    public boolean updateUserLockStatus(@RequestBody SystemUser user,HttpSession session){
        SystemUser admin = (SystemUser) session.getAttribute("user");
        if(admin==null||!admin.getRole().equals("admin")){
            return false;
        }
        return userService.updateUserLocked(user.getId(),user.isLocked());
    }

    @RequestMapping(value = "/getsensitivekeyword", method = RequestMethod.GET)
    public List<SensitiveKeyword> getSensitiveKeyword(@RequestParam long begin, @RequestParam long length,HttpSession session){
        SystemUser admin = (SystemUser) session.getAttribute("user");
        if(admin==null||!admin.getRole().equals("admin")){
            return null;
        }
        return sensitiveKeywordService.getSensitiveKeyword(begin, length);
    }

    @RequestMapping(value = "/getsensitivekeywordnum", method = RequestMethod.GET)
    public long getSensitiveKeywordNum(HttpSession session){
        SystemUser admin = (SystemUser) session.getAttribute("user");
        if(admin==null||!admin.getRole().equals("admin")){
            return -1;
        }
        return sensitiveKeywordService.getSensitiveKeywordNum();
    }

    @RequestMapping(value = "/insertsensitivekeyword",method = RequestMethod.POST)
    public boolean insertSensitiveKeyword(@RequestBody Map<String,String> keywordMap,HttpSession session){
        SystemUser admin = (SystemUser) session.getAttribute("user");
        if(admin==null||!admin.getRole().equals("admin")){
            return false;
        }
        return sensitiveKeywordService.insertSensitiveKeyword(keywordMap.get("keyword"));
    }

    @RequestMapping(value = "/deletesensitivekeyword",method = RequestMethod.DELETE)
    public boolean deleteSensitiveKeyword(@RequestParam(value = "id",required = true) long id,HttpSession session){
        SystemUser admin = (SystemUser) session.getAttribute("user");
        if(admin==null||!admin.getRole().equals("admin")){
            return false;
        }
        return sensitiveKeywordService.deleteSensitiveKeyword(id);
    }

    @RequestMapping(value = "/getuserlist", method = RequestMethod.GET)
    public List<UserListInfo> getUserList(@RequestParam long begin, @RequestParam long length,HttpSession session){
        SystemUser admin = (SystemUser) session.getAttribute("user");
        if(admin==null||!admin.getRole().equals("admin")){
            return null;
        }
        return userService.getUserList(begin,length);
    }

    @RequestMapping(value = "/getusernum", method = RequestMethod.GET)
    public long getUserNum(HttpSession session){
        SystemUser admin = (SystemUser) session.getAttribute("user");
        if(admin==null||!admin.getRole().equals("admin")){
            return -1;
        }
        return userService.getUserNum();
    }
}
