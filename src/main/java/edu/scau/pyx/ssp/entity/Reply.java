package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class Reply {
    private long id;
    private String content;
    private Date time;
    private long sendUserId;
    private long acceptUserId;
    private long commentId;

    public Reply() {
    }

    public Reply(long id, String content, Date time, long sendUserId, long acceptUserId, long commentId) {
        this.id = id;
        this.content = content;
        this.time = time;
        this.sendUserId = sendUserId;
        this.acceptUserId = acceptUserId;
        this.commentId = commentId;
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

    public long getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(long sendUserId) {
        this.sendUserId = sendUserId;
    }

    public long getAcceptUserId() {
        return acceptUserId;
    }

    public void setAcceptUserId(long acceptUserId) {
        this.acceptUserId = acceptUserId;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }
}
