package edu.scau.pyx.ssp.entity;

public class HotSearch {
    private String content;
    private long times;

    public HotSearch() {
    }

    public HotSearch(String content, long times) {
        this.content = content;
        this.times = times;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }
}
