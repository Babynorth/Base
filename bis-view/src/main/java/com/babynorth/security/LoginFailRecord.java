package com.babynorth.security;

import java.util.Date;

/**
 * Created by babynorth on 2017/3/17.
 */
public class LoginFailRecord {

    // 用户登录名
    private String userName;

    // 累计失败次数
    private int failedTimes = 0;

    // 最后一次登录失败时间
    private Date lastFailedTime;

    public LoginFailRecord(String userName, int failedTimes, Date lastFailedTime) {
        this.userName = userName;
        this.failedTimes = failedTimes;
        this.lastFailedTime = lastFailedTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFailedTimes() {
        return failedTimes;
    }

    public void setFailedTimes(int failedTimes) {
        this.failedTimes = failedTimes;
    }

    public Date getLastFailedTime() {
        return lastFailedTime;
    }

    public void setLastFailedTime(Date lastFailedTime) {
        this.lastFailedTime = lastFailedTime;
    }
}
