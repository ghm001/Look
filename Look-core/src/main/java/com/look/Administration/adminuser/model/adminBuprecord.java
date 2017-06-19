package com.look.Administration.adminuser.model;

/**
 * Created by gaohongming on 2017/5/20.
 */
public class adminBuprecord {
    private int id;
    //上传数量
    private int upNum;
    //上传时间
    private String  upTime;
    //上传管理员的id
    private int userId;

    public adminBuprecord(int id, int upNum, String upTime, int userId) {
        this.id = id;
        this.upNum = upNum;
        this.upTime = upTime;
        this.userId = userId;
    }

    public adminBuprecord() {
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "adminBuprecord{" +
                "id=" + id +
                ", upNum=" + upNum +
                ", upTime='" + upTime + '\'' +
                ", userId=" + userId +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUpNum() {
        return upNum;
    }

    public void setUpNum(int upNum) {
        this.upNum = upNum;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
