package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class UserInfo {
    private char gender;
    private Date birthday;
    private String selfIntroduction;
    private Date registrationTime;
    private String avatarUrl;

    public UserInfo() {
    }

    public UserInfo(char gender, Date birthday, String selfIntroduction, Date registrationTime, String avatarUrl) {
        this.gender = gender;
        this.birthday = birthday;
        this.selfIntroduction = selfIntroduction;
        this.registrationTime = registrationTime;
        this.avatarUrl = avatarUrl;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
