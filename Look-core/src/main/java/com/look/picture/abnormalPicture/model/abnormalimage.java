package com.look.picture.abnormalPicture.model;

/**
 * Created by gaohongming on 2017/6/6.
 */
public class abnormalimage {
    private int id;
    private int imageId;
    //判定表的id
    private int judgetableId;
    private int AdminId;
    //产生的时间
    private String productTime;
    //所有的标签
    private String labels;
    //图片地址
    private String imageUrl;

    public abnormalimage() {
    }

    public abnormalimage(int id, int imageId, int judgetableId, int adminId, String productTime, String labels, String imageUrl) {
        this.id = id;
        this.imageId = imageId;
        this.judgetableId = judgetableId;
        AdminId = adminId;
        this.productTime = productTime;
        this.labels = labels;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getJudgetableId() {
        return judgetableId;
    }

    public void setJudgetableId(int judgetableId) {
        this.judgetableId = judgetableId;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public String getProductTime() {
        return productTime;
    }

    public void setProductTime(String productTime) {
        this.productTime = productTime;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "abnormalimage{" +
                "id=" + id +
                ", imageId=" + imageId +
                ", judgetableId=" + judgetableId +
                ", AdminId=" + AdminId +
                ", productTime='" + productTime + '\'' +
                ", labels='" + labels + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
