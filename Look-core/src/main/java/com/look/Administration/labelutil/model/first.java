package com.look.Administration.labelutil.model;

/**
 * Created by gaohongming on 2017/5/17.
 */
public class first extends parent {
    private int id;
    private String labelOne;
    private int minChildId;
    private int maxChildId;
    private int num;
    private int nowMax;
    private String labelNumber;

    public first(String labelNumber, int id, String labelOne, int minChildId, int maxChildId, int num, int nowMax, String labelNumber1) {
        super(labelNumber);
        this.id = id;
        this.labelOne = labelOne;
        this.minChildId = minChildId;
        this.maxChildId = maxChildId;
        this.num = num;
        this.nowMax = nowMax;
        this.labelNumber = labelNumber1;
    }

    public first() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelOne() {
        return labelOne;
    }

    public void setLabelOne(String labelOne) {
        this.labelOne = labelOne;
    }

    public int getMinChildId() {
        return minChildId;
    }

    public void setMinChildId(int minChildId) {
        this.minChildId = minChildId;
    }

    public int getMaxChildId() {
        return maxChildId;
    }

    public void setMaxChildId(int maxChildId) {
        this.maxChildId = maxChildId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNowMax() {
        return nowMax;
    }

    public void setNowMax(int nowMax) {
        this.nowMax = nowMax;
    }

    @Override
    public String getLabelNumber() {
        return labelNumber;
    }

    @Override
    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }

    @Override
    public String toString() {
        return "first{" +
                "id=" + id +
                ", labelOne='" + labelOne + '\'' +
                ", minChildId=" + minChildId +
                ", maxChildId=" + maxChildId +
                ", num=" + num +
                ", nowMax=" + nowMax +
                ", labelNumber='" + labelNumber + '\'' +
                '}';
    }
}
