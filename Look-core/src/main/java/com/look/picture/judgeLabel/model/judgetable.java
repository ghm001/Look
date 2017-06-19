package com.look.picture.judgeLabel.model;

/**
 * Created by gaohongming on 2017/5/25.
 */
public class judgetable {
    private int id;
    //对应的图片的id
    private int imageId;
    //标签，最大10个
    private String label1;
    private String label2;
    private String label3;
    private String label4;
    private String label5;
    private String label6;
    private String label7;
    private String label8;
    private String label9;
    private String label10;
    //对应的标签的状态
    private String Flag1;
    private String Flag2;
    private String Flag3;
    private String Flag4;
    private String Flag5;
    private String Flag6;
    private String Flag7;
    private String Flag8;
    private String Flag9;
    private String Flag10;
    //标签的当前数量
    private int labelNum;
    //为这张图片打标签的人数
    private int useNum;
    //图片的地址
    private String imageUrl;
   //对应的图片的状态   YES    OR   NO
    private String  state;

    public judgetable() {
        this.imageId = 0;
        this.label1 = "";
        this.label2 = "";
        this.label3 = "";
        this.label4 = "";
        this.label5 = "";
        this.label6 = "";
        this.label7 = "";
        this.label8 = "";
        this.label9 = "";
        this.label10 = "";
        Flag1 = "0";
        Flag2 = "0";
        Flag3 = "0";
        Flag4 = "0";
        Flag5 = "0";
        Flag6 = "0";
        Flag7 = "0";
        Flag8 = "0";
        Flag9 = "0";
        Flag10 = "0";
        this.labelNum = 0;
        this.useNum = 0;
        this.imageUrl = "";
        this.state = "0";

    }

    public judgetable(int id, int imageId, String label1, String label2, String label3, String label4, String label5, String label6, String label7, String label8, String label9, String label10, String flag1, String flag2, String flag3, String flag4, String flag5, String flag6, String flag7, String flag8, String flag9, String flag10, int labelNum, int useNum, String imageUrl, String state) {
        this.id = id;
        this.imageId = imageId;
        this.label1 = label1;
        this.label2 = label2;
        this.label3 = label3;
        this.label4 = label4;
        this.label5 = label5;
        this.label6 = label6;
        this.label7 = label7;
        this.label8 = label8;
        this.label9 = label9;
        this.label10 = label10;
        Flag1 = flag1;
        Flag2 = flag2;
        Flag3 = flag3;
        Flag4 = flag4;
        Flag5 = flag5;
        Flag6 = flag6;
        Flag7 = flag7;
        Flag8 = flag8;
        Flag9 = flag9;
        Flag10 = flag10;
        this.labelNum = labelNum;
        this.useNum = useNum;
        this.imageUrl = imageUrl;
        this.state = state;
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

    public String getLabel7() {
        return label7;
    }

    public void setLabel7(String label7) {
        this.label7 = label7;
    }

    public String getLabel8() {
        return label8;
    }

    public void setLabel8(String label8) {
        this.label8 = label8;
    }

    public String getLabel9() {
        return label9;
    }

    public void setLabel9(String label9) {
        this.label9 = label9;
    }

    public String getLabel10() {
        return label10;
    }

    public void setLabel10(String label10) {
        this.label10 = label10;
    }

    public String getFlag1() {
        return Flag1;
    }

    public void setFlag1(String flag1) {
        Flag1 = flag1;
    }

    public String getFlag2() {
        return Flag2;
    }

    public void setFlag2(String flag2) {
        Flag2 = flag2;
    }

    public String getFlag3() {
        return Flag3;
    }

    public void setFlag3(String flag3) {
        Flag3 = flag3;
    }

    public String getFlag4() {
        return Flag4;
    }

    public void setFlag4(String flag4) {
        Flag4 = flag4;
    }

    public String getFlag5() {
        return Flag5;
    }

    public void setFlag5(String flag5) {
        Flag5 = flag5;
    }

    public String getFlag6() {
        return Flag6;
    }

    public void setFlag6(String flag6) {
        Flag6 = flag6;
    }

    public String getFlag7() {
        return Flag7;
    }

    public void setFlag7(String flag7) {
        Flag7 = flag7;
    }

    public String getFlag8() {
        return Flag8;
    }

    public void setFlag8(String flag8) {
        Flag8 = flag8;
    }

    public String getFlag9() {
        return Flag9;
    }

    public void setFlag9(String flag9) {
        Flag9 = flag9;
    }

    public String getFlag10() {
        return Flag10;
    }

    public void setFlag10(String flag10) {
        Flag10 = flag10;
    }

    public int getLabelNum() {
        return labelNum;
    }

    public void setLabelNum(int labelNum) {
        this.labelNum = labelNum;
    }

    public int getUseNum() {
        return useNum;
    }

    public void setUseNum(int useNum) {
        this.useNum = useNum;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "judgetable{" +
                "id=" + id +
                ", imageId=" + imageId +
                ", label1='" + label1 + '\'' +
                ", label2='" + label2 + '\'' +
                ", label3='" + label3 + '\'' +
                ", label4='" + label4 + '\'' +
                ", label5='" + label5 + '\'' +
                ", label6='" + label6 + '\'' +
                ", label7='" + label7 + '\'' +
                ", label8='" + label8 + '\'' +
                ", label9='" + label9 + '\'' +
                ", label10='" + label10 + '\'' +
                ", Flag1='" + Flag1 + '\'' +
                ", Flag2='" + Flag2 + '\'' +
                ", Flag3='" + Flag3 + '\'' +
                ", Flag4='" + Flag4 + '\'' +
                ", Flag5='" + Flag5 + '\'' +
                ", Flag6='" + Flag6 + '\'' +
                ", Flag7='" + Flag7 + '\'' +
                ", Flag8='" + Flag8 + '\'' +
                ", Flag9='" + Flag9 + '\'' +
                ", Flag10='" + Flag10 + '\'' +
                ", labelNum=" + labelNum +
                ", useNum=" + useNum +
                ", imageUrl='" + imageUrl + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
