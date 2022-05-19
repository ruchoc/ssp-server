package edu.scau.pyx.ssp.entity;

public class SystemUser {
    private long id;
    private String name;
    private String password;
    private boolean locked;
    private String role;

    public SystemUser() {
    }

    public SystemUser(long id, String name, String password, boolean locked, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.locked = locked;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
