package com.look.Administration.labelutil.model;

/**
 * Created by gaohongming on 2017/5/17.
 */
public class fifth  extends parent{
    private int id;
    private String labelFifth;
    private int parentId;
    private int helpId;
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
    public String getLabelFifth() {
        return labelFifth;
    }
    public void setLabelFifth(String labelFifth) {
        this.labelFifth = labelFifth;
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
    /**
     * @param id
     * @param labelFifth
     * @param parentId
     * @param helpId
     */
    public fifth(int id, String labelFifth, int parentId, int helpId) {
        super();
        this.id = id;
        this.labelFifth = labelFifth;
        this.parentId = parentId;
        this.helpId = helpId;
    }
    /**
     *
     */
    public fifth() {
        super();
    }

    @Override
    public String toString() {
        return "fifth{" +
                "id=" + id +
                ", labelFifth='" + labelFifth + '\'' +
                ", parentId=" + parentId +
                ", helpId=" + helpId +
                ", labelNumber='" + labelNumber + '\'' +
                '}';
    }
}
