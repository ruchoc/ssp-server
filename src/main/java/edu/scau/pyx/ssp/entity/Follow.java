package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class Follow {
    private long fromUserId;
    private long toUserId;
    private Date followTime;

    public Follow() {
    }

    public Follow(long fromUserId, long toUserId, Date followTime) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.followTime = followTime;
    }

    public long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public long getToUserId() {
        return toUserId;
    }

    public void setToUserId(long toUserId) {
        this.toUserId = toUserId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }
}
