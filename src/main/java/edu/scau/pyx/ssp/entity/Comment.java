package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class Comment {
    private long id;
    private String content;
    private Date time;

    public Comment() {
    }

    public Comment(long id, String content, Date time) {
        this.id = id;
        this.content = content;
        this.time = time;
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
}
