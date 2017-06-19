package com.look.picture.pushPicture.model;

/**
 * Created by gaohongming on 2017/5/28.
 */
public class originPushtable {
    private int id;
    private int adminId;
    private int imageId;
    private String produceTime;
    private String adminName;
    private String imageUrl;

    public originPushtable(int id, int adminId, int imageId, String produceTime, String adminName, String imageUrl) {
        this.id = id;
        this.adminId = adminId;
        this.imageId = imageId;
        this.produceTime = produceTime;
        this.adminName = adminName;
        this.imageUrl = imageUrl;
    }

    public originPushtable() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "originPushtable{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", imageId=" + imageId +
                ", produceTime='" + produceTime + '\'' +
                ", adminName='" + adminName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }


}
