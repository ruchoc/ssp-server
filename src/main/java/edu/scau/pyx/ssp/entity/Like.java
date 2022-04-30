package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class Like {
    private long userId;
    private long shareId;
    private Date likeTime;

    public Like() {
    }

    public Like(long userId, long shareId, Date likeTime) {
        this.userId = userId;
        this.shareId = shareId;
        this.likeTime = likeTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getShareId() {
        return shareId;
    }

    public void setShareId(long shareId) {
        this.shareId = shareId;
    }

    public Date getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Date likeTime) {
        this.likeTime = likeTime;
    }
}
