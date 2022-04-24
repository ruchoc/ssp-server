package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class Reply {
    private int id;
    private String content;
    private Date time;

    public Reply() {
    }

    public Reply(int id, String content, Date time) {
        this.id = id;
        this.content = content;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
