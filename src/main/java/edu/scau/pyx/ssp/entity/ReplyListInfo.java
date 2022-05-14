package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class ReplyListInfo {
    private long id;
    private long sendUserId;
    private String sendUserName;
    private String sendUserAvatarUrl;
    private long acceptUserId;
    private String acceptUserName;
    private String acceptUserAvatarUrl;
    private String content;
    private Date time;

    public ReplyListInfo() {
    }

    public ReplyListInfo(long id, long sendUserId, String sendUserName, String sendUserAvatarUrl, long acceptUserId, String acceptUserName, String acceptUserAvatarUrl, String content, Date time) {
        this.id = id;
        this.sendUserId = sendUserId;
        this.sendUserName = sendUserName;
        this.sendUserAvatarUrl = sendUserAvatarUrl;
        this.acceptUserId = acceptUserId;
        this.acceptUserName = acceptUserName;
        this.acceptUserAvatarUrl = acceptUserAvatarUrl;
        this.content = content;
        this.time = time;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(long sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getSendUserName() {
        return sendUserName;
    }

    public void setSendUserName(String sendUserName) {
        this.sendUserName = sendUserName;
    }

    public String getSendUserAvatarUrl() {
        return sendUserAvatarUrl;
    }

    public void setSendUserAvatarUrl(String sendUserAvatarUrl) {
        this.sendUserAvatarUrl = sendUserAvatarUrl;
    }

    public long getAcceptUserId() {
        return acceptUserId;
    }

    public void setAcceptUserId(long acceptUserId) {
        this.acceptUserId = acceptUserId;
    }

    public String getAcceptUserName() {
        return acceptUserName;
    }

    public void setAcceptUserName(String acceptUserName) {
        this.acceptUserName = acceptUserName;
    }

    public String getAcceptUserAvatarUrl() {
        return acceptUserAvatarUrl;
    }

    public void setAcceptUserAvatarUrl(String acceptUserAvatarUrl) {
        this.acceptUserAvatarUrl = acceptUserAvatarUrl;
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
