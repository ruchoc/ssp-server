package edu.scau.pyx.ssp.entity;

import java.util.Date;

public class UserInfo {
    private Character gender;
    private Date birthday;
    private String selfIntroduction;
    private Date registrationTime;
    private String avatarUrl;
    private long userId;

    public UserInfo() {
    }

    public UserInfo(Character gender, Date birthday, String selfIntroduction, Date registrationTime, String avatarUrl, long userId) {
        this.gender = gender;
        this.birthday = birthday;
        this.selfIntroduction = selfIntroduction;
        this.registrationTime = registrationTime;
        this.avatarUrl = avatarUrl;
        this.userId = userId;
    }



    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
