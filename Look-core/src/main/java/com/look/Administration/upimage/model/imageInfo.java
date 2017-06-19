package com.look.Administration.upimage.model;

/**
 * Created by gaohongming on 2017/5/25.
 */
public class imageInfo {
    private int id;
    //图片的地址
    private String imageUrl;
    //图片的状态  N：未产生推送，默认    p：产生推送   F：完成化
    /*
         当用户上传首次的标签化数据，修改图片的状态为开始推送进行迭代开始
     */
    private String imageFlag;
    //上传时间   样式  2017-5-20
    private String upTime;
    //开始推送的时间
    private String pushTime;
    //完成化的时间
    private String finishTime;
    //上传者的名字
    private String adminName;
    //上传者的id
    private int  adminId;

    public imageInfo(int id, String imageUrl, String imageFlag, String upTime, String pushTime, String finishTime, String adminName, int adminId) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.imageFlag = imageFlag;
        this.upTime = upTime;
        this.pushTime = pushTime;
        this.finishTime = finishTime;
        this.adminName = adminName;
        this.adminId = adminId;
    }

    public imageInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageFlag() {
        return imageFlag;
    }

    public void setImageFlag(String imageFlag) {
        this.imageFlag = imageFlag;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime;
    }

    public String getPushTime() {
        return pushTime;
    }

    public void setPushTime(String pushTime) {
        this.pushTime = pushTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "imageInfo{" +
                "id=" + id +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageFlag='" + imageFlag + '\'' +
                ", upTime='" + upTime + '\'' +
                ", pushTime='" + pushTime + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminId=" + adminId +
                '}';
    }
}
