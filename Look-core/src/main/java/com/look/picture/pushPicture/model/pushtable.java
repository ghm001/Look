package com.look.picture.pushPicture.model;

/**
 * Created by gaohongming on 2017/5/28.
 */
public class pushtable {
    private int id;
    //推送产生者的id   用户 id    腾讯优图则为0
    private int producerId;
    //下面为标签树的id
    private int firstId;
    private int secondId;
    private int thirdId;
    private int fourId;
    private int fifthId;
    //图片的地址
    private String imageUrl;
    //图片信息表的id
    private int imageId;
    //产生推送者的账号
    private String produceName;
    //上传这张图片的管理员的id
    private int adminId;
    //推送产生的时间
    private String produceTime;

    public pushtable() {
        firstId=0;
        secondId=0;
        thirdId=0;
        fourId=0;
        fifthId=0;
    }

    public pushtable(int id, int producerId, int firstId, int secondId, int thirdId, int fourId, int fifthId, String imageUrl, int imageId, String produceName, int adminId, String produceTime) {
        this.id = id;
        this.producerId = producerId;
        this.firstId = firstId;
        this.secondId = secondId;
        this.thirdId = thirdId;
        this.fourId = fourId;
        this.fifthId = fifthId;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
        this.produceName = produceName;
        this.adminId = adminId;
        this.produceTime = produceTime;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProducerId() {
        return producerId;
    }

    public void setProducerId(int producerId) {
        this.producerId = producerId;
    }

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }

    public int getThirdId() {
        return thirdId;
    }

    public void setThirdId(int thirdId) {
        this.thirdId = thirdId;
    }

    public int getFourId() {
        return fourId;
    }

    public void setFourId(int fourId) {
        this.fourId = fourId;
    }

    public int getFifthId() {
        return fifthId;
    }

    public void setFifthId(int fifthId) {
        this.fifthId = fifthId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public String getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(String produceTime) {
        this.produceTime = produceTime;
    }

    @Override
    public String toString() {
        return "pushtable{" +
                "id=" + id +
                ", producerId=" + producerId +
                ", firstId=" + firstId +
                ", secondId=" + secondId +
                ", thirdId=" + thirdId +
                ", fourId=" + fourId +
                ", fifthId=" + fifthId +
                ", imageUrl='" + imageUrl + '\'' +
                ", imageId=" + imageId +
                ", produceName='" + produceName + '\'' +
                ", adminId=" + adminId +
                ", produceTime='" + produceTime + '\'' +
                '}';
    }
}
