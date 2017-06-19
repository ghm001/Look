package com.look.picture.pushPicture.model;

/**
 * Created by gaohongming on 2017/6/1.
 */
public class mostFirstLabel {
   private int firstId;
    private int num;

    public mostFirstLabel() {
    }

    public mostFirstLabel(int firstId, int num) {
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

    @Override
    public String toString() {
        return "mostFirstLabel{" +
                "firstId=" + firstId +
                ", num=" + num +
                '}';
    }

    public void setNum(int num) {
        this.num = num;
    }
}
