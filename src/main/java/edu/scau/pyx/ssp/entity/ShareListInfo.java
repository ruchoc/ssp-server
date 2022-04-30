package edu.scau.pyx.ssp.entity;

import java.util.Date;
import java.util.List;

public class ShareListInfo {
    private long id;
    private String username;
    private String userAvatarUrl;
    private Date time;
    private String content;
    private List<String> pictureList;

    public ShareListInfo() {
    }

    public ShareListInfo(long id, String username, String userAvatarUrl, Date time, String content, List<String> pictureList) {
        this.id = id;
        this.username = username;
        this.userAvatarUrl = userAvatarUrl;
        this.time = time;
        this.content = content;
        this.pictureList = pictureList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAvatarUrl() {
        return userAvatarUrl;
    }

    public void setUserAvatarUrl(String userAvatarUrl) {
        this.userAvatarUrl = userAvatarUrl;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<String> pictureList) {
        this.pictureList = pictureList;
    }
}
