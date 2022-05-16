package edu.scau.pyx.ssp.entity;

public class UserListInfo {
    private long userId;
    private String username;
    private String avatarUrl;
    private boolean locked;

    public UserListInfo() {
    }

    public UserListInfo(long userId, String username, String avatarUrl, boolean locked) {
        this.userId = userId;
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.locked = locked;
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

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
