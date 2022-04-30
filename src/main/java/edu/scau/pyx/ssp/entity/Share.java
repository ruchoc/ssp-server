package edu.scau.pyx.ssp.entity;

public class Share {
    private long id;
    private String content;
    private String state;
    private long userId;

    public Share() {
    }

    public Share(long id, String content, String state, long userId) {
        this.id = id;
        this.content = content;
        this.state = state;
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
