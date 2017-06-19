package com.look.Administration.pictureInfoContral.model;

/**
 * Created by gaohongming on 2017/6/14.
 */
public class FinishModel {
    private int ImageId;
    private String company;
    private String uptime;
    private String imageUrl;
    private String Firstdegree;
    private String Seconddegree;

    public FinishModel() {
    }

    public FinishModel(int imageId, String company, String uptime, String imageUrl, String firstdegree, String seconddegree) {
        ImageId = imageId;
        this.company = company;
        this.uptime = uptime;
        this.imageUrl = imageUrl;
        Firstdegree = firstdegree;
        Seconddegree = seconddegree;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFirstdegree() {
        return Firstdegree;
    }

    public void setFirstdegree(String firstdegree) {
        Firstdegree = firstdegree;
    }

    public String getSeconddegree() {
        return Seconddegree;
    }

    public void setSeconddegree(String seconddegree) {
        Seconddegree = seconddegree;
    }

    @Override
    public String toString() {
        return "FinishModel{" +
                "ImageId=" + ImageId +
                ", company='" + company + '\'' +
                ", uptime='" + uptime + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", Firstdegree='" + Firstdegree + '\'' +
                ", Seconddegree='" + Seconddegree + '\'' +
                '}';
    }
}
