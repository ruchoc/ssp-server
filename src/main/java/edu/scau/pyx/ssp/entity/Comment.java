package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class Comment {
    private long id;
    private String content;
    private Date time;
    private long userId;
    private long shareId;

    public Comment() {
    }

    public Comment(long id, String content, Date time, long userId, long shareId) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.userId = userId;
        this.shareId = shareId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
}
