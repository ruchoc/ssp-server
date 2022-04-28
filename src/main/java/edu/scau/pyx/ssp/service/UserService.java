package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.SystemUser;

public interface UserService {
    public long register(SystemUser systemUser);

    public SystemUser getUser(long userId);

    public boolean updateUsername(long userId, String username);

    public boolean updateUserPassword(long userId, String password);

    public boolean updateUserLocked(long userId, boolean isLocked);
}
