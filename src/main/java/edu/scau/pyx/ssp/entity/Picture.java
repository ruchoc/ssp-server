package edu.scau.pyx.ssp.entity;

public class Picture {
    private long id;
    private String url;

    public Picture() {
    }

    public Picture(long id, String url) {
        this.id = id;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
