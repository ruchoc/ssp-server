package edu.scau.pyx.ssp.service.impl;

import edu.scau.pyx.ssp.entity.SystemUser;
import edu.scau.pyx.ssp.entity.UserListInfo;
import edu.scau.pyx.ssp.mapper.UserMapper;
import edu.scau.pyx.ssp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean register(SystemUser systemUser) {
        return userMapper.insertUser(systemUser);
    }

    @Override
    public boolean signIn(SystemUser systemUser, HttpSession session) {
        SystemUser matchUser = userMapper.getUserByUserName(systemUser.getName());
        if(matchUser==null){
            return false;
        }
        if(systemUser.getPassword().equals(matchUser.getPassword())==true){
            session.setAttribute("user",matchUser);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public SystemUser getUser(long userId) {
        return userMapper.getUser(userId);
    }

    @Override
    public boolean updateUsername(long userId, String username) {
        return userMapper.updateUsername(userId, username);
    }

    @Override
    public boolean updateUserPassword(long userId, String password) {
        return userMapper.updateUserPassword(userId, password);
    }

    @Override
    public boolean updateUserLocked(long userId, boolean isLocked) {
        return userMapper.updateUserLocked(userId, isLocked);
    }

    @Override
    public long getUserId(String username){
        return userMapper.getUserId(username);
    }

    @Override
    public List<UserListInfo> searchUser(String username) {
        StringBuffer sb = new StringBuffer("%");
        for(int i=0;i<username.length();i++){
            sb.append(username.charAt(i));
            sb.append('%');
        }
        username = sb.toString();
        return userMapper.searchUser(username);
    }

    @Override
    public SystemUser getUserByUsername(String username) {
        return userMapper.getUserByUserName(username);
    }

    @Override
    public List<UserListInfo> getUserList(long begin, long length ){
        return userMapper.getUserList(begin,length);
    }

    @Override
    public long getUserNum() {
        return userMapper.getUserNum();
    }
}
