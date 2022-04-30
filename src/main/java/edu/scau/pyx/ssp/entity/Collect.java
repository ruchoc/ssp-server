package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class Collect {
    private long userId;
    private long shareId;
    private Date collectTime;

    public Collect() {
    }

    public Collect(long userId, long shareId, Date collectTime) {
        this.userId = userId;
        this.shareId = shareId;
        this.collectTime = collectTime;
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

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}
