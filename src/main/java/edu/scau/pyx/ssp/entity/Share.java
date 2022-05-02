package edu.scau.pyx.ssp.entity;

public class Share {
    private long id;
    private String content;
    private String state;
    private long likeNum;
    private long collectNum;
    private long commentNum;
    private long userId;

    public Share() {
    }

    public Share(long id, String content, String state, long likeNum, long collectNum, long commentNum, long userId) {
        this.id = id;
        this.content = content;
        this.state = state;
        this.likeNum = likeNum;
        this.collectNum = collectNum;
        this.commentNum = commentNum;
        this.userId = userId;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
