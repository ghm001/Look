package com.look.picture.pushPicture.model;

/**
 * Created by gaohongming on 2017/5/30.
 */
public class appImageGrouping {
    private int id;
    //用户的id
    private int userId;
    //操作的时间
    private String setTime;
    //是保存的还是上传的 N代表无状态    S代表保存的    T代表提交的
    private String Flag;
    //标题名称
    private String titleName;
    private int imageId1;
    private int imageId2;
    private int imageId3;
    private int imageId4;
    private int imageId5;
    private int imageId6;
    private String label1;
    private String label2;
    private String label3;
    private String label4;
    private String label5;
    private String label6;
    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;
    private String imageUrl4;
    private String imageUrl5;
    private String imageUrl6;
    //图片的数量
    private int imageNum;
    //本组对应的二级分类名称   如果为随机推送则为空  如果为一级的，则为一级名称
    private String SecondlabelName;
    //推送的方式    随机推送    猜你喜欢    兴趣推送    热门分类    精选种类
    private String pushWay;

    public appImageGrouping() {
        this.id = 0;
        this.userId = 0;
        this.setTime = 0+"";
        Flag = "N";
        this.titleName = "";
        this.imageId1 = 0;
        this.imageId2 = 0;
        this.imageId3 = 0;
        this.imageId4 = 0;

        this.imageId5 = 0;
        this.imageId6 = 0;
        this.label1 = "";
        this.label2 = "";
        this.label3 = "";
        this.label4 = "";
        this.label5 = "";
        this.label6 = "";
        this.imageUrl1 = "";
        this.imageUrl2 = "";
        this.imageUrl3 = "";
        this.imageUrl4 = "";
        this.imageUrl5 = "";
        this.imageUrl6 = "";
        this.imageNum = 0;
        SecondlabelName = "";
        this.pushWay = "";
    }

    public appImageGrouping(int id, int userId, String setTime, String flag, String titleName, int imageId1, int imageId2, int imageId3, int imageId4, int imageId5, int imageId6, String label1, String label2, String label3, String label4, String label5, String label6, String imageUrl1, String imageUrl2, String imageUrl3, String imageUrl4, String imageUrl5, String imageUrl6, int imageNum, String secondlabelName, String pushWay) {
        this.id = id;
        this.userId = userId;
        this.setTime = setTime;
        Flag = flag;
        this.titleName = titleName;
        this.imageId1 = imageId1;
        this.imageId2 = imageId2;
        this.imageId3 = imageId3;
        this.imageId4 = imageId4;
        this.imageId5 = imageId5;
        this.imageId6 = imageId6;
        this.label1 = label1;
        this.label2 = label2;
        this.label3 = label3;
        this.label4 = label4;
        this.label5 = label5;
        this.label6 = label6;
        this.imageUrl1 = imageUrl1;
        this.imageUrl2 = imageUrl2;
        this.imageUrl3 = imageUrl3;
        this.imageUrl4 = imageUrl4;
        this.imageUrl5 = imageUrl5;
        this.imageUrl6 = imageUrl6;
        this.imageNum = imageNum;
        SecondlabelName = secondlabelName;
        this.pushWay = pushWay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSetTime() {
        return setTime;
    }

    public void setSetTime(String setTime) {
        this.setTime = setTime;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getImageId1() {
        return imageId1;
    }

    public void setImageId1(int imageId1) {
        this.imageId1 = imageId1;
    }

    public int getImageId2() {
        return imageId2;
    }

    public void setImageId2(int imageId2) {
        this.imageId2 = imageId2;
    }

    public int getImageId3() {
        return imageId3;
    }

    public void setImageId3(int imageId3) {
        this.imageId3 = imageId3;
    }

    public int getImageId4() {
        return imageId4;
    }

    public void setImageId4(int imageId4) {
        this.imageId4 = imageId4;
    }

    public int getImageId5() {
        return imageId5;
    }

    public void setImageId5(int imageId5) {
        this.imageId5 = imageId5;
    }

    public int getImageId6() {
        return imageId6;
    }

    public void setImageId6(int imageId6) {
        this.imageId6 = imageId6;
    }

    public String getLabel1() {
        return label1;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }

    public String getLabel2() {
        return label2;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    public String getLabel3() {
        return label3;
    }

    public void setLabel3(String label3) {
        this.label3 = label3;
    }

    public String getLabel4() {
        return label4;
    }

    public void setLabel4(String label4) {
        this.label4 = label4;
    }

    public String getLabel5() {
        return label5;
    }

    public void setLabel5(String label5) {
        this.label5 = label5;
    }

    public String getLabel6() {
        return label6;
    }

    public void setLabel6(String label6) {
        this.label6 = label6;
    }

    public String getImageUrl1() {
        return imageUrl1;
    }

    public void setImageUrl1(String imageUrl1) {
        this.imageUrl1 = imageUrl1;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    public String getImageUrl3() {
        return imageUrl3;
    }

    public void setImageUrl3(String imageUrl3) {
        this.imageUrl3 = imageUrl3;
    }

    public String getImageUrl4() {
        return imageUrl4;
    }

    public void setImageUrl4(String imageUrl4) {
        this.imageUrl4 = imageUrl4;
    }

    public String getImageUrl5() {
        return imageUrl5;
    }

    public void setImageUrl5(String imageUrl5) {
        this.imageUrl5 = imageUrl5;
    }

    public String getImageUrl6() {
        return imageUrl6;
    }

    public void setImageUrl6(String imageUrl6) {
        this.imageUrl6 = imageUrl6;
    }

    public int getImageNum() {
        return imageNum;
    }

    public void setImageNum(int imageNum) {
        this.imageNum = imageNum;
    }

    public String getSecondlabelName() {
        return SecondlabelName;
    }

    public void setSecondlabelName(String secondlabelName) {
        SecondlabelName = secondlabelName;
    }

    public String getPushWay() {
        return pushWay;
    }

    public void setPushWay(String pushWay) {
        this.pushWay = pushWay;
    }

    @Override
    public String toString() {
        return "appImageGrouping{" +
                "id=" + id +
                ", userId=" + userId +
                ", setTime='" + setTime + '\'' +
                ", Flag='" + Flag + '\'' +
                ", titleName='" + titleName + '\'' +
                ", imageId1=" + imageId1 +
                ", imageId2=" + imageId2 +
                ", imageId3=" + imageId3 +
                ", imageId4=" + imageId4 +
                ", imageId5=" + imageId5 +
                ", imageId6=" + imageId6 +
                ", label1='" + label1 + '\'' +
                ", label2='" + label2 + '\'' +
                ", label3='" + label3 + '\'' +
                ", label4='" + label4 + '\'' +
                ", label5='" + label5 + '\'' +
                ", label6='" + label6 + '\'' +
                ", imageUrl1='" + imageUrl1 + '\'' +
                ", imageUrl2='" + imageUrl2 + '\'' +
                ", imageUrl3='" + imageUrl3 + '\'' +
                ", imageUrl4='" + imageUrl4 + '\'' +
                ", imageUrl5='" + imageUrl5 + '\'' +
                ", imageUrl6='" + imageUrl6 + '\'' +
                ", imageNum=" + imageNum +
                ", SecondlabelName='" + SecondlabelName + '\'' +
                ", pushWay='" + pushWay + '\'' +
                '}';
    }
}
