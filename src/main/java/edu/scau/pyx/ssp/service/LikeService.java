package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.Like;
import edu.scau.pyx.ssp.entity.UserListInfo;

import java.util.List;

public interface LikeService {
    public boolean add(Like like);

    public boolean cancel(long shareId, long id);

    public List<UserListInfo> getList(long shareId);
}
