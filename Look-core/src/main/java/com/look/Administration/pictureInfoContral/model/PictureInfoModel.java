package com.look.Administration.pictureInfoContral.model;

/**
 * Created by gaohongming on 2017/6/14.
 */
public class PictureInfoModel {
    private int ImageId;
    private String company;
    private String uptime;
    private String imageUrl;

    public PictureInfoModel() {
    }

    public PictureInfoModel(int imageId, String company, String uptime, String imageUrl) {
        ImageId = imageId;
        this.company = company;
        this.uptime = uptime;
        this.imageUrl = imageUrl;
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

    @Override
    public String toString() {
        return "PictureInfoModel{" +
                "ImageId=" + ImageId +
                ", company='" + company + '\'' +
                ", uptime='" + uptime + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
