package edu.scau.pyx.ssp.entity;

public class Picture {
    private int id;
    private String url;

    public Picture() {
    }

    public Picture(int id, String url) {
        this.id = id;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
