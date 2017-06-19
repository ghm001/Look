package com.look.Administration.labelutil.model;

/**
 * Created by gaohongming on 2017/5/17.
 */
public class second extends parent{
    private int id;
    private String labelSecond;
    private int parentId;
    private int helpId;
    private int minChildId;
    private int maxChildId;
    private int num;
    private int nowMax;
    private String labelNumber;

    public String getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(String labelNumber) {
        this.labelNumber = labelNumber;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLabelSecond() {
        return labelSecond;
    }
    public void setLabelSecond(String labelSecond) {
        this.labelSecond = labelSecond;
    }
    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public int getHelpId() {
        return helpId;
    }
    public void setHelpId(int helpId) {
        this.helpId = helpId;
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
    /**
     * @param id
     * @param labelSecond
     * @param parentId
     * @param helpId
     * @param minChildId
     * @param maxChildId
     * @param num
     * @param nowMax
     */
    public second(int id, String labelSecond, int parentId, int helpId,
                  int minChildId, int maxChildId, int num, int nowMax) {
        super();
        this.id = id;
        this.labelSecond = labelSecond;
        this.parentId = parentId;
        this.helpId = helpId;
        this.minChildId = minChildId;
        this.maxChildId = maxChildId;
        this.num = num;
        this.nowMax = nowMax;
    }
    /**
     *
     */
    public second() {
        super();
    }

    @Override
    public String toString() {
        return "second{" +
                "id=" + id +
                ", labelSecond='" + labelSecond + '\'' +
                ", parentId=" + parentId +
                ", helpId=" + helpId +
                ", minChildId=" + minChildId +
                ", maxChildId=" + maxChildId +
                ", num=" + num +
                ", nowMax=" + nowMax +
                ", labelNumber='" + labelNumber + '\'' +
                '}';
    }
}
