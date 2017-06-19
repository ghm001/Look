package com.look.picture.pushPicture.model;

/**
 * Created by gaohongming on 2017/6/10.
 */
public class mostFirstId {
    private int firstId;
    private int  num;

    public mostFirstId() {
    }

    public mostFirstId(int firstId, int num) {
        this.firstId = firstId;
        this.num = num;
    }

    public int getFirstId() {
        return firstId;
    }

    public void setFirstId(int firstId) {
        this.firstId = firstId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "mostFirstId{" +
                "firstId=" + firstId +
                ", num=" + num +
                '}';
    }
}
