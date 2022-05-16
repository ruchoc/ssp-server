package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserListInfo;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {
    public boolean register(SystemUser systemUser);

    public boolean signIn(SystemUser systemUser, HttpSession session);

    public SystemUser getUser(long userId);

    public boolean updateUsername(long userId, String username);

    public boolean updateUserPassword(long userId, String password);

    public boolean updateUserLocked(long userId, boolean isLocked);

    public long getUserId(String username);

    public List<UserListInfo> searchUser(String username, long begin, long length);

    public SystemUser getUserByUsername(String username);

    public List<UserListInfo> getUserList(long begin, long length);

    public long getUserNum();

    public boolean adminSignIn(SystemUser user, HttpSession session);

    public long getSearchUserNum(String username);
}
