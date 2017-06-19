package com.look.picture.FinishPicture.model;

/**
 * Created by gaohongming on 2017/6/6.
 */
public class FinshPictureModel {
    private int id;
    //图片信息表的id
    private int imageId;
    //图片的地址
    private String imageUrl;
    //完成的时间
    private String FinishTime;
    //标签使用-分割
    private String labels;
    //图片的名字
    private String Imagename;
    //上传这张图片的管理员的id
    private int AdminId;
    //判定表之中的id
    private int judgetableId;
    //一级分类的iD
    private int FirstLabelId;
    //二级分类的id
    private int SecondLabelId;

    public FinshPictureModel() {
        FirstLabelId=0;
        SecondLabelId=0;
    }

    public FinshPictureModel(int id, int imageId, String imageUrl, String finishTime, String labels, String imagename, int adminId, int judgetableId, int firstLabelId, int secondLabelId) {
        this.id = id;
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        FinishTime = finishTime;
        this.labels = labels;
        Imagename = imagename;
        AdminId = adminId;
        this.judgetableId = judgetableId;
        FirstLabelId = firstLabelId;
        SecondLabelId = secondLabelId;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFinishTime() {
        return FinishTime;
    }

    public void setFinishTime(String finishTime) {
        FinishTime = finishTime;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }

    public String getImagename() {
        return Imagename;
    }

    public void setImagename(String imagename) {
        Imagename = imagename;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public int getJudgetableId() {
        return judgetableId;
    }

    public void setJudgetableId(int judgetableId) {
        this.judgetableId = judgetableId;
    }

    public int getFirstLabelId() {
        return FirstLabelId;
    }

    public void setFirstLabelId(int firstLabelId) {
        FirstLabelId = firstLabelId;
    }

    public int getSecondLabelId() {
        return SecondLabelId;
    }

    public void setSecondLabelId(int secondLabelId) {
        SecondLabelId = secondLabelId;
    }

    @Override
    public String toString() {
        return "FinshPictureModel{" +
                "id=" + id +
                ", imageId=" + imageId +
                ", imageUrl='" + imageUrl + '\'' +
                ", FinishTime='" + FinishTime + '\'' +
                ", labels='" + labels + '\'' +
                ", Imagename='" + Imagename + '\'' +
                ", AdminId=" + AdminId +
                ", judgetableId=" + judgetableId +
                ", FirstLabelId=" + FirstLabelId +
                ", SecondLabelId=" + SecondLabelId +
                '}';
    }
}
