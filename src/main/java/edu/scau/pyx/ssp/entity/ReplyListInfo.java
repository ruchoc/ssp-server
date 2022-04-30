package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class ReplyListInfo {
    private long id;
    private String sendUserName;
    private String acceptUserName;
    private String content;
    private Date time;

    public ReplyListInfo() {
    }

    public ReplyListInfo(long id, String sendUserName, String acceptUserName, String content, Date time) {
        this.id = id;
        this.sendUserName = sendUserName;
        this.acceptUserName = acceptUserName;
        this.content = content;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getAcceptUserName() {
        return acceptUserName;
    }

    public void setAcceptUserName(String acceptUserName) {
        this.acceptUserName = acceptUserName;
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
