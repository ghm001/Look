package com.look.app.BrowsePicture.model;

/**
 * Created by gaohongming on 2017/6/11.
 */
public class FirstLabelGroup {
    private int FirstLabelId;
    private int  num;

    public FirstLabelGroup(int firstLabelId, int num) {
        FirstLabelId = firstLabelId;
        this.num = num;
    }

    public FirstLabelGroup() {

    }

    public int getFirstLabelId() {
        return FirstLabelId;
    }

    public void setFirstLabelId(int firstLabelId) {
        FirstLabelId = firstLabelId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public String toString() {
        return "FirstLabelGroup{" +
                "FirstLabelId=" + FirstLabelId +
                ", num=" + num +
                '}';
    }
}
