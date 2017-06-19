package com.look.Administration.labelutil.model;

/**
 * Created by gaohongming on 2017/5/17.
 */
public class third extends parent{
    private int id;
    private String labelThird;
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
    public String getLabelThird() {
        return labelThird;
    }
    public void setLabelThird(String labelThird) {
        this.labelThird = labelThird;
    }
    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public int getHelpIdl() {
        return helpId;
    }
    public void setHelpIdl(int helpIdl) {
        this.helpId = helpIdl;
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
     * @param labelThird
     * @param parentId
     * @param helpIdl
     * @param minChildId
     * @param maxChildId
     * @param num
     * @param nowMax
     */
    public third(int id, String labelThird, int parentId, int helpIdl,
                 int minChildId, int maxChildId, int num, int nowMax) {
        super();
        this.id = id;
        this.labelThird = labelThird;
        this.parentId = parentId;
        this.helpId = helpIdl;
        this.minChildId = minChildId;
        this.maxChildId = maxChildId;
        this.num = num;
        this.nowMax = nowMax;
    }
    /**
     *
     */
    public third() {
        super();
    }

    @Override
    public String toString() {
        return "third{" +
                "id=" + id +
                ", labelThird='" + labelThird + '\'' +
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
