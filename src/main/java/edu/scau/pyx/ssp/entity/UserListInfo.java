package edu.scau.pyx.ssp.entity;

public class UserListInfo {
    private long userId;
    private String username;
    private String avatarUrl;

    public UserListInfo() {
    }

    public UserListInfo(long userId, String username, String avatarUrl) {
        this.userId = userId;
        this.username = username;
        this.avatarUrl = avatarUrl;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
