package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private char gender;
    private String selfIntroduction;
    private Date registrationTime;
    private boolean blocked;

    public User() {
    }

    public User(int id, String name, String password, char gender, String selfIntroduction, Date registrationTime, boolean blocked) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.selfIntroduction = selfIntroduction;
        this.registrationTime = registrationTime;
        this.blocked = blocked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
