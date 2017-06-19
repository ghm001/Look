package com.look.picture.pushPicture.model;

/**
 * Created by gaohongming on 2017/5/30.
 */
public class mostclassification {
    /*
    查询对应的数据最多的推送标签  数据库中没有对应的表  这个只查找  推送表
     */
    private int secondId;
    private int  num;

    public mostclassification() {
    }

    public mostclassification(int secondId, int num) {
        this.secondId = secondId;
        this.num = num;
    }

    public int getSecondId() {
        return secondId;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "mostclassification{" +
                "secondId=" + secondId +
                ", num=" + num +
                '}';
    }
}
