package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class CommentListInfo {
    private long id;
    private long userId;
    private String username;
    private String avatarUrl;
    private String content;
    private Date time;

    public CommentListInfo() {
    }

    public CommentListInfo(long id, long userId, String username, String avatarUrl, String content, Date time) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.content = content;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
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
}
