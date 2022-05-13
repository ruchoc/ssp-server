package edu.scau.pyx.ssp.service;

import edu.scau.pyx.ssp.entity.Like;

public interface LikeService {
    public boolean add(Like like);

    public boolean cancel(long shareId, long id);
}
