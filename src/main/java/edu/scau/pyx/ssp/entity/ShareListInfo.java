package edu.scau.pyx.ssp.entity;

import java.util.Date;
import java.util.List;

public class ShareListInfo {
    private long id;
    private String username;
    private String userAvatarUrl;
    private Date time;
    private String content;
    private List<Picture> pictureList;
    private long likeNum;
    private long collectNum;
    private long commentNum;
    private boolean isLiked = false;
    private boolean isCollected = false;

    public ShareListInfo() {
    }

    public ShareListInfo(long id, String username, String userAvatarUrl, Date time, String content, List<Picture> pictureList, long likeNum, long collectNum, long commentNum, boolean isLiked, boolean isCollected) {
        this.id = id;
        this.username = username;
        this.userAvatarUrl = userAvatarUrl;
        this.time = time;
        this.content = content;
        this.pictureList = pictureList;
        this.likeNum = likeNum;
        this.collectNum = collectNum;
        this.commentNum = commentNum;
        this.isLiked = isLiked;
        this.isCollected = isCollected;
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

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    public long getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(long likeNum) {
        this.likeNum = likeNum;
    }

    public long getCollectNum() {
        return collectNum;
    }

    public void setCollectNum(long collectNum) {
        this.collectNum = collectNum;
    }

    public long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(long commentNum) {
        this.commentNum = commentNum;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }
}
