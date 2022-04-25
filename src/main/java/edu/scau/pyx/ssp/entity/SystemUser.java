package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class SystemUser {
    private long id;
    private String name;
    private String password;
    private boolean locked;

    public SystemUser() {
    }

    public SystemUser(long id, String name, String password, boolean locked) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.locked = locked;
    }

    public SystemUser(String name, String password) {
        this.name = name;
        this.password = password;
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
}
