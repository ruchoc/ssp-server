package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.SystemUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public SystemUser getUserByUserName(String username);

    public boolean insertUser(SystemUser user);
}
