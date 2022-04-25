package edu.scau.pyx.ssp.mapper;

import edu.scau.pyx.ssp.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface RoleMapper {
    public List<Role> getRolesByUserName(String username);
}
