package edu.scau.pyx.ssp.entity;

public class SensitiveKeyword {
    private long id;
    private String keyword;

    public SensitiveKeyword() {
    }

    public SensitiveKeyword(long id, String keyword) {
        this.id = id;
        this.keyword = keyword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
